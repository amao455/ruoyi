<template>
  <div class="login">
    <div class="login-shell">
      <section class="login-brand">
        <div class="brand-badge">CMKC</div>
        <h1>中煤科工后台管理系统</h1>
        <p>统一管理业务数据、系统权限与运营监控。</p>
        <div class="brand-meta">
          <span>安全认证</span>
          <span>权限管控</span>
          <span>高效运维</span>
        </div>
      </section>

      <section class="login-panel">
        <div class="login-panel__header">
          <h2>欢迎登录</h2>
          <p>请输入账号信息进入系统</p>
        </div>

        <el-form
          ref="loginForm"
          :model="loginForm"
          :rules="loginRules"
          class="login-form"
        >
          <el-form-item prop="username">
            <el-input
              v-model="loginForm.username"
              type="text"
              auto-complete="off"
              placeholder="账号"
            >
              <svg-icon
                slot="prefix"
                icon-class="user"
                class="el-input__icon input-icon"
              />
            </el-input>
          </el-form-item>

          <el-form-item prop="password">
            <el-input
              v-model="loginForm.password"
              type="password"
              auto-complete="off"
              placeholder="密码"
              show-password
              @keyup.enter.native="handleLogin"
            >
              <svg-icon
                slot="prefix"
                icon-class="password"
                class="el-input__icon input-icon"
              />
            </el-input>
          </el-form-item>

          <el-form-item prop="code" v-if="captchaEnabled">
            <div class="login-code-row">
              <el-input
                v-model="loginForm.code"
                auto-complete="off"
                placeholder="验证码"
                @keyup.enter.native="handleLogin"
              >
                <svg-icon
                  slot="prefix"
                  icon-class="validCode"
                  class="el-input__icon input-icon"
                />
              </el-input>
              <button type="button" class="login-code" @click="getCode">
                <img :src="codeUrl" class="login-code-img" alt="验证码" />
              </button>
            </div>
          </el-form-item>

          <div class="login-options">
            <el-checkbox v-model="loginForm.rememberMe">记住密码</el-checkbox>
            <router-link v-if="register" class="link-type" :to="'/register'"
              >立即注册</router-link
            >
          </div>

          <el-form-item class="login-submit">
            <el-button
              :loading="loading"
              type="primary"
              @click.native.prevent="handleLogin"
            >
              <span v-if="!loading">登录系统</span>
              <span v-else>登录中...</span>
            </el-button>
          </el-form-item>
        </el-form>
      </section>
    </div>

    <!--  底部  -->
    <div class="el-login-footer">
      <span>Copyright © 2018-2024 ruoyi.vip All Rights Reserved.</span>
    </div>
  </div>
</template>

<script>
import { getCodeImg } from "@/api/login";
import Cookies from "js-cookie";
import { encrypt, decrypt } from "@/utils/jsencrypt";

export default {
  name: "Login",
  data() {
    return {
      codeUrl: "",
      loginForm: {
        username: "admin",
        password: "admin123",
        rememberMe: false,
        code: "",
        uuid: "",
      },
      // 登录表单验证规则
      loginRules: {
        username: [
          { required: true, trigger: "blur", message: "请输入您的账号" },
        ],
        password: [
          { required: true, trigger: "blur", message: "请输入您的密码" },
        ],
        code: [{ required: true, trigger: "change", message: "请输入验证码" }],
      },
      loading: false,
      // 验证码开关
      captchaEnabled: true,
      // 注册开关
      register: false,
      redirect: undefined,
    };
  },
  watch: {
    // 监听当前路由的变化
    $route: {
      handler: function (route) {
        // 从路由查询参数中获取redirect参数
        this.redirect = route.query && route.query.redirect;
      },
      // 在组件初始化时立即执行一次，而不是等待被监听对象属性发生变化时才执行
      immediate: true,
    },
  },
  created() {
    this.getCode();
    this.getCookie();
  },
  methods: {
    getCode() {
      getCodeImg().then((res) => {
        this.captchaEnabled =
          res.captchaEnabled === undefined ? true : res.captchaEnabled;
        if (this.captchaEnabled) {
          this.codeUrl = "data:image/gif;base64," + res.img;
          this.loginForm.uuid = res.uuid;
        }
      });
    },
    getCookie() {
      const username = Cookies.get("username");
      const password = Cookies.get("password");
      const rememberMe = Cookies.get("rememberMe");
      this.loginForm = {
        username: username === undefined ? this.loginForm.username : username,
        password:
          password === undefined ? this.loginForm.password : decrypt(password),
        rememberMe: rememberMe === undefined ? false : Boolean(rememberMe),
        code: this.loginForm.code,
        uuid: this.loginForm.uuid,
      };
    },

    // 处理用户登录操作的核心方法
    handleLogin() {
      // el-form表单验证
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          //  记住密码处理
          if (this.loginForm.rememberMe) {
            Cookies.set("username", this.loginForm.username, { expires: 30 });
            Cookies.set("password", encrypt(this.loginForm.password), {
              expires: 30,
            });
            Cookies.set("rememberMe", this.loginForm.rememberMe, {
              expires: 30,
            });
          } else {
            Cookies.remove("username");
            Cookies.remove("password");
            Cookies.remove("rememberMe");
          }

          // 执行登录请求
          this.$store
            .dispatch("Login", this.loginForm)
            .then(() => {
              // 登录成功时调用
              this.$router.push({ path: this.redirect || "/" }).catch(() => {});
            })
            .catch(() => {
              // 请求失败时调用
              // 重置加载状态，刷新验证码
              this.loading = false;
              if (this.captchaEnabled) {
                this.getCode();
              }
            });
        }
      });
    },
  },
};
</script>

<style rel="stylesheet/scss" lang="scss">
.login {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100%;
  padding: 56px 24px;
  background-image: url("../assets/images/login-background.jpg");
  background-position: center;
  background-size: cover;
  overflow: hidden;

  &::before {
    content: "";
    position: absolute;
    inset: 0;
    background:
      linear-gradient(115deg, rgba(10, 32, 72, 0.9), rgba(13, 74, 102, 0.72) 48%, rgba(4, 28, 55, 0.58)),
      radial-gradient(circle at 72% 20%, rgba(34, 197, 164, 0.22), transparent 28%);
  }
}

.login-shell {
  position: relative;
  z-index: 1;
  display: grid;
  grid-template-columns: minmax(0, 1fr) 430px;
  gap: 64px;
  align-items: center;
  width: min(1080px, 100%);
}

.login-brand {
  color: #fff;

  .brand-badge {
    display: inline-flex;
    align-items: center;
    justify-content: center;
    width: 72px;
    height: 72px;
    margin-bottom: 26px;
    border: 1px solid rgba(255, 255, 255, 0.42);
    border-radius: 18px;
    background: rgba(255, 255, 255, 0.12);
    box-shadow: 0 18px 48px rgba(0, 0, 0, 0.22);
    font-size: 20px;
    font-weight: 700;
  }

  h1 {
    margin: 0;
    font-size: 42px;
    line-height: 1.22;
    font-weight: 700;
    letter-spacing: 0;
  }

  p {
    max-width: 520px;
    margin: 18px 0 0;
    color: rgba(255, 255, 255, 0.78);
    font-size: 17px;
    line-height: 1.8;
  }

  .brand-meta {
    display: flex;
    flex-wrap: wrap;
    gap: 12px;
    margin-top: 34px;

    span {
      min-height: 36px;
      padding: 8px 14px;
      border: 1px solid rgba(255, 255, 255, 0.24);
      border-radius: 6px;
      background: rgba(255, 255, 255, 0.1);
      color: rgba(255, 255, 255, 0.86);
      font-size: 14px;
      line-height: 20px;
    }
  }
}

.login-panel {
  width: 100%;
  border: 1px solid rgba(255, 255, 255, 0.72);
  border-radius: 8px;
  background: rgba(255, 255, 255, 0.96);
  box-shadow: 0 24px 70px rgba(5, 22, 48, 0.28);
  padding: 34px 34px 28px;
  backdrop-filter: blur(12px);
}

.login-panel__header {
  margin-bottom: 26px;

  h2 {
    margin: 0;
    color: #172033;
    font-size: 26px;
    line-height: 1.35;
    font-weight: 700;
    letter-spacing: 0;
  }

  p {
    margin: 8px 0 0;
    color: #677489;
    font-size: 14px;
    line-height: 1.6;
  }
}

.login-form {
  width: 100%;

  .el-form-item {
    margin-bottom: 20px;
  }

  .el-input {
    height: 46px;

    input {
      height: 46px;
      border-color: #d8e0ea;
      border-radius: 6px;
      background: #f8fafc;
      color: #172033;
      font-size: 15px;
      transition: border-color 0.2s ease, box-shadow 0.2s ease, background 0.2s ease;

      &:focus {
        border-color: #1d7dd8;
        background: #fff;
        box-shadow: 0 0 0 3px rgba(29, 125, 216, 0.12);
      }
    }
  }

  .input-icon {
    height: 46px;
    width: 15px;
    margin-left: 4px;
    color: #7b8ba1;
  }
}

.login-code-row {
  display: grid;
  grid-template-columns: minmax(0, 1fr) 118px;
  gap: 12px;
}

.login-code {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 46px;
  padding: 0;
  border: 1px solid #d8e0ea;
  border-radius: 6px;
  background: #fff;
  cursor: pointer;
  overflow: hidden;
  transition: border-color 0.2s ease, box-shadow 0.2s ease;

  &:hover,
  &:focus {
    border-color: #1d7dd8;
    box-shadow: 0 0 0 3px rgba(29, 125, 216, 0.1);
    outline: none;
  }
}

.login-code-img {
  display: block;
  width: 100%;
  height: 44px;
  object-fit: cover;
}

.login-options {
  display: flex;
  align-items: center;
  justify-content: space-between;
  min-height: 32px;
  margin: -2px 0 18px;
  color: #5f6f84;

  .link-type {
    color: #1d7dd8;
    font-size: 14px;
  }
}

.login-submit {
  margin-bottom: 0 !important;

  .el-button {
    width: 100%;
    min-height: 46px;
    border: 0;
    border-radius: 6px;
    background: linear-gradient(135deg, #176ec4, #0f9f8f);
    box-shadow: 0 14px 26px rgba(23, 110, 196, 0.24);
    font-size: 16px;
    font-weight: 600;
    letter-spacing: 0;
    transition: transform 0.18s ease, box-shadow 0.18s ease, opacity 0.18s ease;

    &:hover,
    &:focus {
      background: linear-gradient(135deg, #125fac, #0c8f81);
      box-shadow: 0 16px 30px rgba(23, 110, 196, 0.3);
      transform: translateY(-1px);
    }

    &:active {
      transform: translateY(0);
    }
  }
}

.el-login-footer {
  height: 40px;
  line-height: 40px;
  position: fixed;
  bottom: 0;
  width: 100%;
  text-align: center;
  color: rgba(255, 255, 255, 0.78);
  font-family: Arial;
  font-size: 12px;
  letter-spacing: 0;
  z-index: 1;
}

@media (max-width: 900px) {
  .login {
    align-items: flex-start;
    padding: 36px 18px 64px;
  }

  .login-shell {
    grid-template-columns: 1fr;
    gap: 28px;
  }

  .login-brand {
    text-align: center;

    .brand-badge {
      width: 58px;
      height: 58px;
      margin-bottom: 18px;
      border-radius: 14px;
      font-size: 16px;
    }

    h1 {
      font-size: 28px;
    }

    p {
      margin-right: auto;
      margin-left: auto;
      font-size: 15px;
    }

    .brand-meta {
      justify-content: center;
      margin-top: 20px;
    }
  }

  .login-panel {
    max-width: 430px;
    margin: 0 auto;
    padding: 28px 22px 24px;
  }
}

@media (max-width: 420px) {
  .login-code-row {
    grid-template-columns: 1fr;
  }

  .login-code {
    width: 100%;
  }

  .el-login-footer {
    padding: 0 12px;
    line-height: 18px;
  }
}
</style>
