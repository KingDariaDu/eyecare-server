// pages/message/message.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    id: '',
    content: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.getMessages();
  },

  // 获取留言列表
  getMessages() {
    wx.request({
      url: 'http://localhost:8888/message/list',
      method: 'GET',
      data: {
        pageNum: 1,
        pageSize: 10
      },
      success: (res) => {
        if (res.data.success) {
          this.setData({
            messages: res.data.data
          });
        }
      }
    });
  },

  // 输入用户ID
  inputUserid(e) {
    this.setData({
      id: e.detail.value
    });
  },
  
  // 输入留言内容
  inputContent(e) {
    this.setData({
      content: e.detail.value
    });
  },
  
  // 提交留言
  handleSubmit() {
    if (!this.data.id || this.data.id.trim() === '') {
      wx.showToast({
        title: '请输入用户ID',
        icon: 'none'
      });
      return;
    }
    
    if (!this.data.content || this.data.content.trim() === '') {
      wx.showToast({
        title: '请输入留言内容',
        icon: 'none'
      });
      return;
    }
    
    wx.request({
      url: 'http://localhost:8888/message/create',
      method: 'POST',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      data: {
        userId: parseInt(this.data.id),
        content: this.data.content
      },
      success: (res) => {
        if (res.data.success) {
          wx.showToast({
            title: '留言成功',
            icon: 'success'
          });
          this.setData({
            content: ''
          });
          this.getMessages();
        }
      }
    });
  },

  // 输入内容变化
  handleContentChange(e) {
    this.setData({
      content: e.detail.value
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

  }
})