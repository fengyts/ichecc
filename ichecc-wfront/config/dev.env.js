'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  // BASE_API_URL: '"http://localhost:8090/ichecc-front"',
  BASE_API_URL: '"http://icheccfront.checc.cc"',
  BASE_WEB_URL: '"http://icweb.checc.cc"'
})
