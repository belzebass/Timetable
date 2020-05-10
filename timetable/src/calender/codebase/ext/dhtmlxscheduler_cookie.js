/*

@license
dhtmlxScheduler v.5.3.7 Professional Evaluation

This software is covered by DHTMLX Evaluation License. Contact sales@dhtmlx.com to get Commercial or Enterprise license. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(e){!function(){function t(e,t,i){var n=e+"="+i+(t?"; "+t:"");document.cookie=n}function i(e){var t=e+"=";if(document.cookie.length>0){var i=document.cookie.indexOf(t);if(-1!=i){i+=t.length;var n=document.cookie.indexOf(";",i);return-1==n&&(n=document.cookie.length),document.cookie.substring(i,n)}}return""}var n=!0;e.attachEvent("onBeforeViewChange",function(a,r,o,s){if(n&&e._get_url_nav){var d=e._get_url_nav();(d.date||d.mode||d.event)&&(n=!1)}
var _=(e._obj.id||"scheduler")+"_settings";if(n){n=!1;var l=i(_);if(l){e._min_date||(e._min_date=s),l=unescape(l).split("@"),l[0]=this._helpers.parseDate(l[0]);var h=this.isViewExists(l[1])?l[1]:o,c=isNaN(+l[0])?s:l[0];return window.setTimeout(function(){e.setCurrentView(c,h)},1),!1}}return t(_,"expires=Sun, 31 Jan 9999 22:00:00 GMT",escape(this._helpers.formatDate(s||r)+"@"+(o||a))),!0});var a=e._load;e._load=function(){var t=arguments;if(e._date)a.apply(this,t);else{var i=this
;window.setTimeout(function(){a.apply(i,t)},1)}}}()});