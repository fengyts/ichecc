import {fmtDate} from '../js/date';

const filters = {
  formatDate: function (startTime) {
    var date = new Date(startTime);
    return fmtDate(date, "M.dd");
  },
  formatMoney: function (money) {
    var fmt = money / 10000;
    return parseFloat(fmt).toFixed(2);
  }
};

export default filters;
