package com.ruoyi.common.config.serializer;

import java.io.IOException;
import java.util.Objects;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.ruoyi.common.annotation.Sensitive;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.enums.DesensitizedType;
import com.ruoyi.common.utils.SecurityUtils;

/**
 * 数据脱敏序列化过滤
 * 在将java对象序列化为json时，如果字段有Sensitive注解，则进行数据脱敏
 * 非管理员用户才进行数据脱敏，管理员可以看到原始数据
 * @author ruoyi
 */
public class SensitiveJsonSerializer extends JsonSerializer<String> implements ContextualSerializer
{
    private DesensitizedType desensitizedType;

    // 序列化是调用
    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException
    {
        if (desensitization())
        {
            gen.writeString(desensitizedType.desensitizer().apply(value));
        }
        else
        {
            gen.writeString(value);
        }
    }

    /**
     * 在序列化开始前调用，检查当前属性是否有 @Sensitive 注解
     * 如果有且是String类型，则保存脱敏类型配置并返回当前序列化器
     */
    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property)
            throws JsonMappingException
    {
        Sensitive annotation = property.getAnnotation(Sensitive.class);
        if (Objects.nonNull(annotation) && Objects.equals(String.class, property.getType().getRawClass()))
        {
            this.desensitizedType = annotation.desensitizedType();
            return this;
        }
        return prov.findValueSerializer(property.getType(), property);
    }

    /**
     * 是否需要脱敏处理
     */
    private boolean desensitization()
    {
        try
        {
            LoginUser securityUser = SecurityUtils.getLoginUser();
            // 管理员不脱敏
            return !securityUser.getUser().isAdmin();
        }
        catch (Exception e)
        {
            return true;
        }
    }
}
