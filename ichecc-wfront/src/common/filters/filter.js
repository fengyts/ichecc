import {fmtDate} from '../js/date';

const filters = {
  formatDate: function (datetime, fmt) {
    var date = new Date(datetime);
    return fmtDate(date, fmt); // M.dd
  },
  /**
   * type: 1-万元(默认为万元,若为万元，此参数可不传)；0-元
   */
  formatMoney: function (money, type) {
    if(!type){
      var fmt = money / 10000;
      return parseFloat(fmt).toFixed(2);
    } else {
      return parseFloat(money).toFixed(2);
    }
  }
};

export default filters;
