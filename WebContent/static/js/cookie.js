(function() {
	window.CookieUtil = {
		/**
		 * 添加cookie
		 * @param name -cookie名
		 * @param value -cookie值
		 * @param expiresDay -cookie过期时间
		 */
		setCookie : function(key, value, expiresDay) {
			var date = new Date();
			date.setTime(date.getTime() + expiresDay * 86400 * 1000);//指定保留多少天
			document.cookie = key + "=" + escape(value) + "; expires=" + date.toGMTString();
		},

		/**
		 * 通过设置cookie过期时间删除cookie
		 * 
		 * @param name -待删除的cookie名
		 * @param value  -待删除的cookie值 过期时间小于当前系统时间，就会被删除
		 */
		removeCookie : function(key, value) {
			document.cookie = key + "=" + escape(value) + "; expires=Fri, 31 Dec 1999 23:59:59 GMT;";
		},

		/**
		 * 根据cookie名获取cookie值
		 */
		getCookie : function(key) {
			var aCookie = document.cookie.split("; ");
			for (var i = 0; i < aCookie.length; i++) {
				var aCrumb = aCookie[i].split("=");
				if (key == aCrumb[0])
					return unescape(aCrumb[1]);
			}
			return null;
		}
	}

})();