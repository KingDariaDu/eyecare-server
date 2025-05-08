// pages/result/result.js
Page({
  data: {
    resultList: [],
    pageNum: 1,
    pageSize: 10,
    hasMore: true
  },
  onLoad(options) {
    this.loadResultData();
  },
  loadResultData() {
    if (!this.data.hasMore) return;
    
    wx.request({
      url: 'http://localhost:8888/result/list',
      method: 'GET',
      data: {
        pageNum: this.data.pageNum,
        pageSize: this.data.pageSize
      },
      success: (res) => {
        if (res.data.code === 200) {
          const newData = res.data.data || [];
          this.setData({
            resultList: this.data.resultList.concat(newData),
            hasMore: newData.length >= this.data.pageSize
          });
          this.data.pageNum++;
        }
      }
    });
  },
  onReachBottom() {
    this.loadResultData();
  }
})