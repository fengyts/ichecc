import '../js/date';

const filter = {
  formatDate: function(startTime) {
    var date = new Date(startTime);
    return formatDate(date, "M.dd");
  },
  formatMoney: function(money) {
    var fmt = money / 10000;
    return parseFloat(fmt).toFixed(2);
  }
};

export default filter;