/** window localStorage */

export default {
  setLocalStorage: function (id, key, value) {
    let args = arguments;
    if (!args || args.length < 2) {
      throw "setLocalStorage() params is not allowed.";
      return;
    }
    // if (!value) {
    //   return;
    // }
    let icheccwf = window.localStorage._icheccwf_;
    if (icheccwf) {
      icheccwf = JSON.parse(icheccwf);
      if (!icheccwf[id]) {
        icheccwf[id] = {};
      }
    } else {
      icheccwf = {};
      icheccwf[id] = {};
    }
    if (args.length == 2) {
      icheccwf[id] = key;
    } else {
      icheccwf[id][key] = value;
    }
    window.localStorage._icheccwf_ = JSON.stringify(icheccwf);
  },
  /** 获取本地localStorage 里的数据, key参数可选*/
  getLocalStorage: function (id, key) {
    let args = arguments;
    if (!args || args.length == 0) {
      return;
    }
    let icheccwf = window.localStorage._icheccwf_;
    if (!icheccwf) {
      return undefined;
    }
    icheccwf = JSON.parse(icheccwf)[id];
    if (!icheccwf) {
      return undefined;
    }
    return args.length == 1 ? icheccwf : icheccwf[key];
  },
  /** 删除本地localStorage 里的数据, key参数可选, 若key为空，则删除id的选项*/
  removeLocalStorage: function (id, key) {
    let args = arguments;
    if (!args || args.length == 0) {
      return;
    }
    let icheccwf = window.localStorage.getItem('_icheccwf_');
    if (!icheccwf) {
      return undefined;
    }
    icheccwf = JSON.parse(icheccwf)[id];
    if (!icheccwf) {
      return undefined;
    }
    if (args.length == 1) {
      window.localStorage.removeItem(id);
    } else {
      if (key) {
        let _t = {};
        for (let kt in icheccwf) {
          if (kt === key) {
            continue;
          }
          _t.kt = icheccwf[key];
        }
        setLocalStorage(id, _t);
      }
    }
  }

}
