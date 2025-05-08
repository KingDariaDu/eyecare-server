// pages/register/register.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    username: '',
    password: '',
    confirmPassword: '',
    phone: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

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
    this.setData({ username: e.detail.value });
  },

  inputPassword: function(e) {
    this.setData({ password: e.detail.value });
  },

  inputConfirmPassword: function(e) {
    this.setData({ confirmPassword: e.detail.value });
  },

  inputPhone: function(e) {
    this.setData({ phone: e.detail.value });
  },

  handleRegister: function() {
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
    if (this.data.password !== this.data.confirmPassword) {
      wx.showToast({
        title: '两次密码不一致',
        icon: 'none'
      });
      return;
    }
    if (!this.data.phone || this.data.phone.trim() === '') {
      wx.showToast({
        title: '请输入手机号',
        icon: 'none'
      });
      return;
    }

    wx.request({
      url: 'http://localhost:8888/user/register',
      method: 'POST',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      data: {
        username: this.data.username,
        password: this.data.password,
        phone: this.data.phone
      },
      success: (res) => {
        if (res.data.success) {
          wx.showToast({
            title: '注册成功',
            icon: 'success'
          });
          wx.navigateTo({
            url: '/pages/login/login'
          });
        } else {
          wx.showToast({
            title: res.data.msg || '注册失败',
            icon: 'none'
          });
        }
      },
      fail: (err) => {
        wx.showToast({
          title: '网络错误，请重试',
          icon: 'none'
        });
      }
    });
  },

  navigateToLogin: function() {
    wx.navigateTo({
      url: '/pages/login/login'
    });
  }
})