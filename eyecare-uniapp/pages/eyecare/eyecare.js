// pages/eyecare/eyecare.js
Page({
  data: {
    bannerList: [
      { id: 1, image: '../../images/banner1.jpg' },
      { id: 2, image: '../../images/banner2.jpg' }
    ],
    examList: [
      { id: 1, name: '视力检测', image: '../../images/exam1.png' },
      { id: 2, name: '色盲检测', image: '../../images/exam2.png' },
      { id: 3, name: '散光检测', image: '../../images/exam3.png' }
    ]
  },
  onLoad(options) {
    // 页面加载时初始化数据
  }
})