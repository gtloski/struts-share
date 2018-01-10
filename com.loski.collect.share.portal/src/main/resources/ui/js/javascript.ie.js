(function () {
    Array.prototype.indexOf = Array.prototype.indexOf || function (a) {
        for (var i = 0, l = this.length; i < l; i++)
            if (a === this[i]) return i;
        return -1;
    };
})();