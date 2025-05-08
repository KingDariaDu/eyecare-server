// pages/login/login.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    username: '',
    password: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

  },

  navigateToRegister: function() {
    wx.navigateTo({
      url: '/pages/register/register'
    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  },
  
  inputUsername: function(e) {
    this.setData({
      username: e.detail.value
    });
  },

  inputPassword: function(e) {
    this.setData({
      password: e.detail.value
    });
  },

  handleLogin: function() {
    const that = this;
    if (!this.data.username || this.data.username.trim() === '') {
      wx.showToast({
        title: '请输入用户名',
        icon: 'none'
      });
      return;
    }
    if (!this.data.password || this.data.password.trim() === '') {
      wx.showToast({
        title: '请输入密码',
        icon: 'none'
      });
      return;
    }
    
    wx.request({
      url: 'http://localhost:8888/user/login',
      method: 'POST',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      data: {
        username: this.data.username,
        password: this.data.password
      },
      success(res) {
        if (res.data.code === 200) {
          wx.showToast({
            title: '登录成功',
            icon: 'success'
          });
          wx.setStorageSync('token', res.data.data.token);
          wx.switchTab({
            url: '/pages/eyecare/eyecare'
          });
        } else {
          wx.showToast({
            title: res.data.message || '登录失败',
            icon: 'none'
          });
        }
      },
      fail(err) {
        wx.showToast({
          title: '网络错误，请重试',
          icon: 'none'
        });
      }
    });
  },
  
  testConnection: function() {
    wx.request({
      url: 'http://localhost:8888/user/login',
      method: 'POST',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      data: {
        username: 'admin',
        password: '123456'
      },
      success(res) {
        console.log('测试响应:', res.data);
        wx.showToast({
          title: '测试数据已发送',
          icon: 'none'
        });
      },
      fail(err) {
        console.error('测试错误:', err);
        wx.showToast({
          title: '测试失败: ' + err.errMsg,
          icon: 'none'
        });
      }
    });
  }
})