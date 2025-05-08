// pages/appointment/appointment.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    examList: [],
    selectedExamIndex: null,
    appointmentDate: '',
    userId: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.getExamList();
  },
  
  handleExamChange(e) {
    this.setData({
      selectedExamIndex: parseInt(e.detail.value)
    });
  },
  
  handleDateChange(e) {
    this.setData({
      appointmentDate: e.detail.value
    });
  },
  
  inputUserid(e) {
    this.setData({
      userId: e.detail.value
    });
  },
  
  handleSubmit() {
    if (this.data.selectedExamIndex === null) {
      wx.showToast({
        title: '请选择检查项目',
        icon: 'none'
      });
      return;
    }
    
    if (!this.data.appointmentDate || this.data.appointmentDate.trim() === '') {
      wx.showToast({
        title: '请选择预约日期',
        icon: 'none'
      });
      return;
    }
    
    const userId = this.data.userId;
    if (!userId) {
      wx.showToast({
        title: '请输入用户ID',
        icon: 'none'
      });
      return;
    }
    
    console.log('examId:', this.data.selectedExamIndex + 1);
    wx.request({
      url: 'http://localhost:8888/appointment/create',
      method: 'POST',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      data: {
        userId: userId,
        examId: this.data.selectedExamIndex + 1,
        appointmentTime: this.data.appointmentDate
      },
      success: (res) => {
        if (res.data.code === 0) {
          wx.showToast({
            title: '预约成功',
            icon: 'success'
          });
        } else {
          wx.showToast({
            title: res.data.msg || '预约失败',
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
  
  getExamList() {
    wx.request({
      url: 'http://localhost:8888/exam/list',
      method: 'GET',
      header: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      data: {
        pageNum: 1,
        pageSize: 1
      },
      success: (res) => {
        if (res.data.code === 0) {
          this.setData({
            examList: res.data.data.map(item => item.name)
          });
        }
      }
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