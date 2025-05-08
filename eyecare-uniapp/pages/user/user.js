Page({
  data: {
    username: '',
    name: '',
    gender: '男',
    age: '',
    email: '',
    isLogin: false,
    userId: ''
  },
  onLoad: function() {
    // 检查登录状态
    const token = wx.getStorageSync('token');
    if (token && token !== '') {
      this.setData({ isLogin: true });
      this.getUserInfo();
      //如果登录了，就显示用户已经登录
      wx.showToast({
        title: '用户已经登录',
        icon: 'success' 
      })
    } else {
      wx.redirectTo({
        url: '/pages/login/login'
      });
      return;
    }
  },
  getUserInfo: function() {
    // 从本地存储获取用户信息
    const userInfo = wx.getStorageSync('userInfo');
    if (userInfo) {
      this.setData({
        ...userInfo,
        userId: userInfo.id
      });
      // 显示用户数据
      wx.showToast({
        title: '用户数据加载成功',
        icon: 'success'
      });
    }
  },
  inputName: function(e) {
    this.setData({ name: e.detail.value });
  },
  changeGender: function(e) {
    this.setData({ gender: this.data.gender === '男' ? '女' : '男' });
  },
  inputAge: function(e) {
    this.setData({ age: e.detail.value });
  },
  inputEmail: function(e) {
    this.setData({ email: e.detail.value });
  },
  inputUsername: function(e) {
    this.setData({ username: e.detail.value });
  },
  updateUserInfo: function() {
    // 调用接口更新用户信息
    wx.request({
      url: 'http://localhost:8888/user/update',
      method: 'POST',
      data: {
        id: this.data.id,
        name: this.data.name,
        gender: this.data.gender,
        age: this.data.age,
        email: this.data.email
      },
      success: (res) => {
        if (res.data.success) {
          wx.showToast({ title: '更新成功' });
        } else {
          wx.showToast({ title: '更新失败', icon: 'none' });
        }
      }
    });
  }
});