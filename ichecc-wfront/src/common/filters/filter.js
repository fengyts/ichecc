import {fmtDate} from '../js/date';

const filters = {
  formatDate: function (datetime, fmt) {
    var date = new Date(datetime);
    return fmtDate(date, fmt); // M.dd
  },
  formatMoney: function (money) {
    var fmt = money / 10000;
    return parseFloat(fmt).toFixed(2);
  }
};

export default filters;
