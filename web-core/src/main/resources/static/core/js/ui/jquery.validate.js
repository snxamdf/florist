(function(e){e.extend(e.fn,{validate:function(t){if(!this.length){t&&t.debug&&window.console&&console.warn("nothing selected, can't validate, returning nothing");return}var i=e.data(this[0],"validator");if(i){return i}i=new e.validator(t,this[0]);e.data(this[0],"validator",i);if(i.settings.onsubmit){var s=this.find("input, button");s.filter(".cancel").click(function(){i.cancelSubmit=true});if(i.settings.submitHandler){s.filter(":submit").click(function(){i.submitButton=this})}this.submit(function(t){if(i.settings.debug)t.preventDefault();function s(){if(i.settings.submitHandler){if(i.submitButton){var t=e("<input type='hidden'/>").attr("name",i.submitButton.name).val(i.submitButton.value).appendTo(i.currentForm)}i.settings.submitHandler.call(i,i.currentForm);if(i.submitButton){t.remove()}return false}return true}if(i.cancelSubmit){i.cancelSubmit=false;return s()}if(i.form()){if(i.pendingRequest){i.formSubmitted=true;return false}return s()}else{i.focusInvalid();return false}})}return i},valid:function(){if(e(this[0]).is("form")){return this.validate().form()}else{var t=true;var i=e(this[0].form).validate();this.each(function(){t&=i.element(this)});return t}},removeAttrs:function(t){var i={},s=this;e.each(t.split(/\s/),function(e,t){i[t]=s.attr(t);s.removeAttr(t)});return i},rules:function(t,i){var s=this[0];if(t){var r=e.data(s.form,"validator").settings;var n=r.rules;var a=e.validator.staticRules(s);switch(t){case"add":e.extend(a,e.validator.normalizeRule(i));n[s.name]=a;if(i.messages)r.messages[s.name]=e.extend(r.messages[s.name],i.messages);break;case"remove":if(!i){delete n[s.name];return a}var u={};e.each(i.split(/\s/),function(e,t){u[t]=a[t];delete a[t]});return u}}var o=e.validator.normalizeRules(e.extend({},e.validator.metadataRules(s),e.validator.classRules(s),e.validator.attributeRules(s),e.validator.staticRules(s)),s);if(o.required){var l=o.required;delete o.required;o=e.extend({required:l},o)}return o}});e.extend(e.expr[":"],{blank:function(t){return!e.trim(""+t.value)},filled:function(t){return!!e.trim(""+t.value)},unchecked:function(e){return!e.checked}});e.validator=function(t,i){this.settings=e.extend(true,{},e.validator.defaults,t);this.currentForm=i;this.init()};e.validator.format=function(t,i){if(arguments.length==1)return function(){var i=e.makeArray(arguments);i.unshift(t);return e.validator.format.apply(this,i)};if(arguments.length>2&&i.constructor!=Array){i=e.makeArray(arguments).slice(1)}if(i.constructor!=Array){i=[i]}e.each(i,function(e,i){t=t.replace(new RegExp("\\{"+e+"\\}","g"),i)});return t};e.extend(e.validator,{defaults:{messages:{},groups:{},rules:{},errorClass:"error",validClass:"valid",errorElement:"label",focusInvalid:true,errorContainer:e([]),errorLabelContainer:e([]),onsubmit:true,ignore:":hidden",ignoreTitle:false,onfocusin:function(e,t){this.lastActive=e;if(this.settings.focusCleanup&&!this.blockFocusCleanup){this.settings.unhighlight&&this.settings.unhighlight.call(this,e,this.settings.errorClass,this.settings.validClass);this.addWrapper(this.errorsFor(e)).hide()}},onfocusout:function(e,t){if(!this.checkable(e)&&(e.name in this.submitted||!this.optional(e))){this.element(e)}},onkeyup:function(e,t){if(e.name in this.submitted||e==this.lastElement){this.element(e)}},onclick:function(e,t){if(e.name in this.submitted)this.element(e);else if(e.parentNode.name in this.submitted)this.element(e.parentNode)},highlight:function(t,i,s){if(t.type==="radio"){this.findByName(t.name).addClass(i).removeClass(s)}else{e(t).addClass(i).removeClass(s)}},unhighlight:function(t,i,s){if(t.type==="radio"){this.findByName(t.name).removeClass(i).addClass(s)}else{e(t).removeClass(i).addClass(s)}}},setDefaults:function(t){e.extend(e.validator.defaults,t)},messages:{required:"This field is required.",remote:"Please fix this field.",email:"Please enter a valid email address.",url:"Please enter a valid URL.",date:"Please enter a valid date.",dateISO:"Please enter a valid date (ISO).",number:"Please enter a valid number.",digits:"Please enter only digits.",creditcard:"Please enter a valid credit card number.",equalTo:"Please enter the same value again.",accept:"Please enter a value with a valid extension.",maxlength:e.validator.format("Please enter no more than {0} characters."),minlength:e.validator.format("Please enter at least {0} characters."),rangelength:e.validator.format("Please enter a value between {0} and {1} characters long."),range:e.validator.format("Please enter a value between {0} and {1}."),max:e.validator.format("Please enter a value less than or equal to {0}."),min:e.validator.format("Please enter a value greater than or equal to {0}.")},autoCreateRanges:false,prototype:{init:function(){this.labelContainer=e(this.settings.errorLabelContainer);this.errorContext=this.labelContainer.length&&this.labelContainer||e(this.currentForm);this.containers=e(this.settings.errorContainer).add(this.settings.errorLabelContainer);this.submitted={};this.valueCache={};this.pendingRequest=0;this.pending={};this.invalid={};this.reset();var t=this.groups={};e.each(this.settings.groups,function(i,s){e.each(s.split(/\s/),function(e,s){t[s]=i})});var i=this.settings.rules;e.each(i,function(t,s){i[t]=e.validator.normalizeRule(s)});function s(t){var i=e.data(this[0].form,"validator"),s="on"+t.type.replace(/^validate/,"");i.settings[s]&&i.settings[s].call(i,this[0],t)}e(this.currentForm).validateDelegate("[type='text'], [type='password'], [type='file'], select, textarea, "+"[type='number'], [type='search'] ,[type='tel'], [type='url'], "+"[type='email'], [type='datetime'], [type='date'], [type='month'], "+"[type='week'], [type='time'], [type='datetime-local'], "+"[type='range'], [type='color'] ","focusin focusout keyup",s).validateDelegate("[type='radio'], [type='checkbox'], select, option","click",s);if(this.settings.invalidHandler)e(this.currentForm).bind("invalid-form.validate",this.settings.invalidHandler)},form:function(){this.checkForm();e.extend(this.submitted,this.errorMap);this.invalid=e.extend({},this.errorMap);if(!this.valid())e(this.currentForm).triggerHandler("invalid-form",[this]);this.showErrors();return this.valid()},checkForm:function(){this.prepareForm();for(var e=0,t=this.currentElements=this.elements();t[e];e++){this.check(t[e])}return this.valid()},element:function(t){t=this.validationTargetFor(this.clean(t));this.lastElement=t;this.prepareElement(t);this.currentElements=e(t);var i=this.check(t);if(i){delete this.invalid[t.name]}else{this.invalid[t.name]=true}if(!this.numberOfInvalids()){this.toHide=this.toHide.add(this.containers)}this.showErrors();return i},showErrors:function(t){if(t){e.extend(this.errorMap,t);this.errorList=[];for(var i in t){this.errorList.push({message:t[i],element:this.findByName(i)[0]})}this.successList=e.grep(this.successList,function(e){return!(e.name in t)})}this.settings.showErrors?this.settings.showErrors.call(this,this.errorMap,this.errorList):this.defaultShowErrors()},resetForm:function(){if(e.fn.resetForm)e(this.currentForm).resetForm();this.submitted={};this.lastElement=null;this.prepareForm();this.hideErrors();this.elements().removeClass(this.settings.errorClass)},numberOfInvalids:function(){return this.objectLength(this.invalid)},objectLength:function(e){var t=0;for(var i in e)t++;return t},hideErrors:function(){this.addWrapper(this.toHide).hide()},valid:function(){return this.size()==0},size:function(){return this.errorList.length},focusInvalid:function(){if(this.settings.focusInvalid){try{e(this.findLastActive()||this.errorList.length&&this.errorList[0].element||[]).filter(":visible").focus().trigger("focusin")}catch(t){}}},findLastActive:function(){var t=this.lastActive;return t&&e.grep(this.errorList,function(e){return e.element.name==t.name}).length==1&&t},elements:function(){var t=this,i={};return e(this.currentForm).find("input, select, textarea").not(":submit, :reset, :image, [disabled]").not(this.settings.ignore).filter(function(){!this.name&&t.settings.debug&&window.console&&console.error("%o has no name assigned",this);if(this.name in i||!t.objectLength(e(this).rules()))return false;i[this.name]=true;return true})},clean:function(t){return e(t)[0]},errors:function(){return e(this.settings.errorElement+"."+this.settings.errorClass,this.errorContext)},reset:function(){this.successList=[];this.errorList=[];this.errorMap={};this.toShow=e([]);this.toHide=e([]);this.currentElements=e([])},prepareForm:function(){this.reset();this.toHide=this.errors().add(this.containers)},prepareElement:function(e){this.reset();this.toHide=this.errorsFor(e)},check:function(t){t=this.validationTargetFor(this.clean(t));var i=e(t).rules();var s=false;for(var r in i){var n={method:r,parameters:i[r]};try{var a=e.validator.methods[r].call(this,t.value.replace(/\r/g,""),t,n.parameters);if(a=="dependency-mismatch"){s=true;continue}s=false;if(a=="pending"){this.toHide=this.toHide.not(this.errorsFor(t));return}if(!a){this.formatAndAdd(t,n);return false}}catch(u){this.settings.debug&&window.console&&console.log("exception occured when checking element "+t.id+", check the '"+n.method+"' method",u);throw u}}if(s)return;if(this.objectLength(i))this.successList.push(t);return true},customMetaMessage:function(t,i){if(!e.metadata)return;var s=this.settings.meta?e(t).metadata()[this.settings.meta]:e(t).metadata();return s&&s.messages&&s.messages[i]},customMessage:function(e,t){var i=this.settings.messages[e];return i&&(i.constructor==String?i:i[t])},findDefined:function(){for(var e=0;e<arguments.length;e++){if(arguments[e]!==undefined)return arguments[e]}return undefined},defaultMessage:function(t,i){return this.findDefined(this.customMessage(t.name,i),this.customMetaMessage(t,i),!this.settings.ignoreTitle&&t.title||undefined,e.validator.messages[i],"<strong>Warning: No message defined for "+t.name+"</strong>")},formatAndAdd:function(e,t){var i=this.defaultMessage(e,t.method),s=/\$?\{(\d+)\}/g;if(typeof i=="function"){i=i.call(this,t.parameters,e)}else if(s.test(i)){i=jQuery.format(i.replace(s,"{$1}"),t.parameters)}this.errorList.push({message:i,element:e});this.errorMap[e.name]=i;this.submitted[e.name]=i},addWrapper:function(e){if(this.settings.wrapper)e=e.add(e.parent(this.settings.wrapper));return e},defaultShowErrors:function(){for(var e=0;this.errorList[e];e++){var t=this.errorList[e];this.settings.highlight&&this.settings.highlight.call(this,t.element,this.settings.errorClass,this.settings.validClass);this.showLabel(t.element,t.message)}if(this.errorList.length){this.toShow=this.toShow.add(this.containers)}if(this.settings.success){for(var e=0;this.successList[e];e++){this.showLabel(this.successList[e])}}if(this.settings.unhighlight){for(var e=0,i=this.validElements();i[e];e++){this.settings.unhighlight.call(this,i[e],this.settings.errorClass,this.settings.validClass)}}this.toHide=this.toHide.not(this.toShow);this.hideErrors();this.addWrapper(this.toShow).show()},validElements:function(){return this.currentElements.not(this.invalidElements())},invalidElements:function(){return e(this.errorList).map(function(){return this.element})},showLabel:function(t,i){var s=this.errorsFor(t);if(s.length){s.removeClass(this.settings.validClass).addClass(this.settings.errorClass);s.attr("generated")&&s.html(i)}else{s=e("<"+this.settings.errorElement+"/>").attr({"for":this.idOrName(t),generated:true}).addClass(this.settings.errorClass).html(i||"");if(this.settings.wrapper){s=s.hide().show().wrap("<"+this.settings.wrapper+"/>").parent()}if(!this.labelContainer.append(s).length)this.settings.errorPlacement?this.settings.errorPlacement(s,e(t)):s.insertAfter(t)}if(!i&&this.settings.success){s.text("");typeof this.settings.success=="string"?s.addClass(this.settings.success):this.settings.success(s)}this.toShow=this.toShow.add(s)},errorsFor:function(t){var i=this.idOrName(t);return this.errors().filter(function(){return e(this).attr("for")==i})},idOrName:function(e){return this.groups[e.name]||(this.checkable(e)?e.name:e.id||e.name)},validationTargetFor:function(e){if(this.checkable(e)){e=this.findByName(e.name).not(this.settings.ignore)[0]}return e},checkable:function(e){return/radio|checkbox/i.test(e.type)},findByName:function(t){var i=this.currentForm;return e(document.getElementsByName(t)).map(function(e,s){return s.form==i&&s.name==t&&s||null})},getLength:function(t,i){switch(i.nodeName.toLowerCase()){case"select":return e("option:selected",i).length;case"input":if(this.checkable(i))return this.findByName(i.name).filter(":checked").length}return t.length},depend:function(e,t){return this.dependTypes[typeof e]?this.dependTypes[typeof e](e,t):true},dependTypes:{"boolean":function(e,t){return e},string:function(t,i){return!!e(t,i.form).length},"function":function(e,t){return e(t)}},optional:function(t){return!e.validator.methods.required.call(this,e.trim(t.value),t)&&"dependency-mismatch"},startRequest:function(e){if(!this.pending[e.name]){this.pendingRequest++;this.pending[e.name]=true}},stopRequest:function(t,i){this.pendingRequest--;if(this.pendingRequest<0)this.pendingRequest=0;delete this.pending[t.name];if(i&&this.pendingRequest==0&&this.formSubmitted&&this.form()){e(this.currentForm).submit();this.formSubmitted=false}else if(!i&&this.pendingRequest==0&&this.formSubmitted){e(this.currentForm).triggerHandler("invalid-form",[this]);this.formSubmitted=false}},previousValue:function(t){return e.data(t,"previousValue")||e.data(t,"previousValue",{old:null,valid:true,message:this.defaultMessage(t,"remote")})}},classRuleSettings:{required:{required:true},email:{email:true},url:{url:true},date:{date:true},dateISO:{dateISO:true},dateDE:{dateDE:true},number:{number:true},numberDE:{numberDE:true},digits:{digits:true},creditcard:{creditcard:true}},addClassRules:function(t,i){t.constructor==String?this.classRuleSettings[t]=i:e.extend(this.classRuleSettings,t)},classRules:function(t){var i={};var s=e(t).attr("class");s&&e.each(s.split(" "),function(){if(this in e.validator.classRuleSettings){e.extend(i,e.validator.classRuleSettings[this])}});return i},attributeRules:function(t){var i={};var s=e(t);for(var r in e.validator.methods){var n;if(r==="required"&&typeof e.fn.prop==="function"){n=s.prop(r)}else{n=s.attr(r)}if(n){i[r]=n}else if(s[0].getAttribute("type")===r){i[r]=true}}if(i.maxlength&&/-1|2147483647|524288/.test(i.maxlength)){delete i.maxlength}return i},metadataRules:function(t){if(!e.metadata)return{};var i=e.data(t.form,"validator").settings.meta;return i?e(t).metadata()[i]:e(t).metadata()},staticRules:function(t){var i={};var s=e.data(t.form,"validator");if(s.settings.rules){i=e.validator.normalizeRule(s.settings.rules[t.name])||{}}return i},normalizeRules:function(t,i){e.each(t,function(s,r){if(r===false){delete t[s];return}if(r.param||r.depends){var n=true;switch(typeof r.depends){case"string":n=!!e(r.depends,i.form).length;break;case"function":n=r.depends.call(i,i);break}if(n){t[s]=r.param!==undefined?r.param:true}else{delete t[s]}}});e.each(t,function(s,r){t[s]=e.isFunction(r)?r(i):r});e.each(["minlength","maxlength","min","max"],function(){if(t[this]){t[this]=Number(t[this])}});e.each(["rangelength","range"],function(){if(t[this]){t[this]=[Number(t[this][0]),Number(t[this][1])]}});if(e.validator.autoCreateRanges){if(t.min&&t.max){t.range=[t.min,t.max];delete t.min;delete t.max}if(t.minlength&&t.maxlength){t.rangelength=[t.minlength,t.maxlength];delete t.minlength;delete t.maxlength}}if(t.messages){delete t.messages}return t},normalizeRule:function(t){if(typeof t=="string"){var i={};e.each(t.split(/\s/),function(){i[this]=true});t=i}return t},addMethod:function(t,i,s){e.validator.methods[t]=i;e.validator.messages[t]=s!=undefined?s:e.validator.messages[t];if(i.length<3){e.validator.addClassRules(t,e.validator.normalizeRule(t))}},methods:{required:function(t,i,s){if(!this.depend(s,i))return"dependency-mismatch";switch(i.nodeName.toLowerCase()){case"select":var r=e(i).val();return r&&r.length>0;case"input":if(this.checkable(i))return this.getLength(t,i)>0;default:return e.trim(t).length>0}},remote:function(t,i,s){if(this.optional(i))return"dependency-mismatch";var r=this.previousValue(i);if(!this.settings.messages[i.name])this.settings.messages[i.name]={};r.originalMessage=this.settings.messages[i.name].remote;this.settings.messages[i.name].remote=r.message;s=typeof s=="string"&&{url:s}||s;if(this.pending[i.name]){return"pending"}if(r.old===t){return r.valid}r.old=t;var n=this;this.startRequest(i);var a={};a[i.name]=t;e.ajax(e.extend(true,{url:s,mode:"abort",port:"validate"+i.name,dataType:"json",data:a,success:function(s){n.settings.messages[i.name].remote=r.originalMessage;var a=s===true;if(a){var u=n.formSubmitted;n.prepareElement(i);n.formSubmitted=u;n.successList.push(i);n.showErrors()}else{var o={};var l=s||n.defaultMessage(i,"remote");o[i.name]=r.message=e.isFunction(l)?l(t):l;n.showErrors(o)}r.valid=a;n.stopRequest(i,a)}},s));return"pending"},minlength:function(t,i,s){return this.optional(i)||this.getLength(e.trim(t),i)>=s},maxlength:function(t,i,s){return this.optional(i)||this.getLength(e.trim(t),i)<=s},rangelength:function(t,i,s){var r=this.getLength(e.trim(t),i);return this.optional(i)||r>=s[0]&&r<=s[1]},min:function(e,t,i){return this.optional(t)||e>=i},max:function(e,t,i){return this.optional(t)||e<=i},range:function(e,t,i){return this.optional(t)||e>=i[0]&&e<=i[1]},email:function(e,t){return this.optional(t)||/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))$/i.test(e)},url:function(e,t){return this.optional(t)||/^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(e)},date:function(e,t){return this.optional(t)||!/Invalid|NaN/.test(new Date(e))},dateISO:function(e,t){return this.optional(t)||/^\d{4}[\/-]\d{1,2}[\/-]\d{1,2}$/.test(e)},number:function(e,t){return this.optional(t)||/^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/.test(e)},digits:function(e,t){return this.optional(t)||/^\d+$/.test(e)},creditcard:function(e,t){if(this.optional(t))return"dependency-mismatch";if(/[^0-9 -]+/.test(e))return false;var i=0,s=0,r=false;e=e.replace(/\D/g,"");for(var n=e.length-1;n>=0;n--){var a=e.charAt(n);var s=parseInt(a,10);if(r){if((s*=2)>9)s-=9}i+=s;r=!r}return i%10==0},accept:function(e,t,i){i=typeof i=="string"?i.replace(/,/g,"|"):"png|jpe?g|gif";return this.optional(t)||e.match(new RegExp(".("+i+")$","i"))},equalTo:function(t,i,s){var r=e(s).unbind(".validate-equalTo").bind("blur.validate-equalTo",function(){e(i).valid()});return t==r.val()}}});e.format=e.validator.format})(jQuery);(function(e){var t={};if(e.ajaxPrefilter){e.ajaxPrefilter(function(e,i,s){var r=e.port;if(e.mode=="abort"){if(t[r]){t[r].abort()}t[r]=s}})}else{var i=e.ajax;e.ajax=function(s){var r=("mode"in s?s:e.ajaxSettings).mode,n=("port"in s?s:e.ajaxSettings).port;if(r=="abort"){if(t[n]){t[n].abort()}return t[n]=i.apply(this,arguments)}return i.apply(this,arguments)}}})(jQuery);(function(e){if(!jQuery.event.special.focusin&&!jQuery.event.special.focusout&&document.addEventListener){e.each({focus:"focusin",blur:"focusout"},function(t,i){e.event.special[i]={setup:function(){this.addEventListener(t,s,true)},teardown:function(){this.removeEventListener(t,s,true)},handler:function(t){arguments[0]=e.event.fix(t);arguments[0].type=i;return e.event.handle.apply(this,arguments)}};function s(t){t=e.event.fix(t);t.type=i;return e.event.handle.call(this,t)}})}e.extend(e.fn,{validateDelegate:function(t,i,s){return this.bind(i,function(i){var r=e(i.target);if(r.is(t)){return s.apply(r,arguments)}})}})})(jQuery);