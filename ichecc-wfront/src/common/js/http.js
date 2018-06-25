import axios from 'axios'


axios.defaults.baseURL = process.env.NODE_ENV === 'production' ? process.env.BASE_API_URL : ''
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

var httpRequestUtil = {
  post(url, data) {
    let params = new URLSearchParams();
    for (let key in data) {
      params.append(key, data[key]);
    }
    return new Promise((resolve, reject) => {
      axios.post(url, params).then(response => {
        resolve(response.data);
      }, err => {
        reject(err);
      }).catch((response) => {
        console.log('f', response)
      })
    })
  }
}

export default httpRequestUtil;
