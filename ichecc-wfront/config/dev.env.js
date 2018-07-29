'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  // BASE_API_URL: '"http://localhost:8090/ichecc-front/"',
  BASE_API_URL: '"http://ic.checc.cc/ichecc-front/"',
  BASE_WEB_URL: '"http://192.168.9.108:8080"'
  // BASE_WEB_URL: '"http://www.checc.cc"'
})
