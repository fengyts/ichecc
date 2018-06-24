/**
 * 本安全编码采用crypto-js库,github地址如下：
 * https://github.com/brix/crypto-js
 */

// import CryptoJS from 'crypto-js';
// import AES from 'crypto-js/aes';
// import Base64 from 'crypto-js/enc-base64';

var CryptoJS = require("crypto-js"); // 引入crypto-js 所有lib
// 单独引入crypto-js某些模块
// var ENC = require("crypto-js/enc-utf8");
// var PAD = require("crypto-js/pad-pkcs7");
// var AES = require("crypto-js/aes");
// var Base64 = require("crypto-js/enc-base64");

var Crypto = {};

// 必须与后台配置一样,否则将无法解码
const _iv = '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',
  _key = CryptoJS.enc.Utf8.parse('f5e_E&D8$hAX5pG%');
const cfg = {
  iv: CryptoJS.enc.Utf8.parse(_iv),
  mode: CryptoJS.mode.CBC,
  padding: CryptoJS.pad.Pkcs7
};

Crypto.encryptAes = function (data) {
  return CryptoJS.AES.encrypt(data, _key, cfg).toString(); // 返回的是base64格式的密文
}

Crypto.decryptAes = function (data) {
  return CryptoJS.AES.decrypt(data, _key, cfg).toString(CryptoJS.enc.Utf8);
}

export default Crypto;
