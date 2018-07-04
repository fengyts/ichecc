const qs = require('querystring')
// import Vue from 'vue'
import axios from 'axios'

axios.defaults.baseURL = process.env.NODE_ENV === 'production' ? process.env.BASE_API_URL : ''
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'; // 此处必须制定charset否则中文会乱码

// 使用拦截器后权限验证会出错
// axios.interceptors.request.use(
//   config => {
//     // if (store.state.token) { // 判断是否存在token，如果存在的话，则每个http header都加上token
//     // config.headers.Authorization = "";
//     // }
//     // config.headers.Authorization = "testAuth12345678"; // java后台获取：HttpServletRequest req: req.getHeader("Authorization");
//     config.headers.userId = getUserInfo();
//     return config;
//   },
//   err => {
//     return Promise.reject(err);
//   }
// );

var getUserInfo = function () {
  let _user = JSON.parse(window.localStorage._icheccwf_)["icheccuser"];
  return _user ? _user.id : "";
}

var httpRequestUtil = {
  post: function (url, data) {
    /* 
    浏览器兼容性不好
    let params = new URLSearchParams();
    for (let key in data) {
      params.append(key, data[key]);
    } */
    // 是否是登陆请求
    let authSymbol = data.authSymbol;
    if(!authSymbol){
      data.userId = getUserInfo();
    }
    let params = qs.stringify(data);
    return new Promise((resolve, reject) => {
      axios.post(url, params).then(response => {
        resolve(response.data);
      }, err => {
        reject(err);
      }).catch(response => {
        console.log('error', response);
      })
    })
  },
  get: function (url, data) {
    let _data = {};
    if(data){
      let params = data;
      params.userId = getUserInfo();
      _data.params = data;
    } else {
      _data = {'params': {'userId': getUserInfo()}};
    }
    
    return new Promise((resolve, reject) => {
      axios.get(url, _data).then(response => {
        resolve(response.data);
      }, err => {
        reject(err);
      }).catch(response => {
        console.log('error', response);
      })
    });
  }

}



export default httpRequestUtil;
