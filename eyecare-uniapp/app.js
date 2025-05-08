// 小程序入口文件
App({
  globalData: {
    userInfo: null,
    apiBaseUrl: 'http://localhost:8888'
  },
  onLaunch: function() {
    // 小程序初始化
  },
  login: function(callback) {
    // 登录逻辑
  },
  makeAppointment: function(data, callback) {
    // 预约逻辑
  },
  sendMessage: function(data, callback) {
    // 留言逻辑
  }
})