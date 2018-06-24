;(function () {


    //获得ID
    $(document).ready(function(){
        $.ajax({
            //请求方式
            type:"GET",
            //文件位置
            url:"./get/ids",
            //返回数据格式为json,也可以是其他格式如
            dataType: "json",
            //请求成功后要执行的函数，拼接html
            success: function(data){
                $.each(data,function(i,data){
                    console.log("1")
                    console.log(data)
                    var id = data;
                    var image = "./get/image?id="+id
                    var contentPage="./get/content?id="+id
                    //获得图片的blob
                    console.log("2")
                    // var imgBLOB = data;
                    // var image = window.URL.createObjectURL(imgBLOB);
                    //获得剩余内容并拼接
                    $.ajax({
                        //请求方式
                        type: "GET",
                        //文件位置
                        url: contentPage,
                        //返回数据格式为json,也可以是其他格式如
                        dataType: "json",
                        //请求成功后要执行的函数，拼接html
                        success: function (data) {
                            console.log("3")
                            var author = data.author;
                            var content = data.content;
                            var message = "<h4>" + author + ": </h4>" + content

                            // <div class="item">
                            //        <div class="animate-box">
                            //        <a href="images/img_1.jpg" class="image-popup fh5co-board-img" title="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?"><img src="images/img_1.jpg" alt="Free HTML5 Bootstrap template"></a>
                            //         </div>
                            //         <div class="fh5co-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?</div>
                            //      </div>

                            var html = "<div class=\"item\">";
                            html += "<div class=\"animate-box\">";
                            html += "<a href=\"" + image + "\" class=\"image-popup fh5co-board-img\" title=\"" + content + "\"><img id=" + id + " src=\"" + image + "\" alt=\"Free HTML5 Bootstrap template\" ></a>"
                            html += "</div>"
                            html += "<div class=\"fh5co-desc\">" + message + "</div>"
                            html += "</div>"
                            $("#fh5co-board").append(html)
                            $(function(){
                                magnifPopup();
                                animateBoxWayPoint();
                            });

                        }
                    })
                })
            }});
    });


	'use strict';

	// iPad and iPod detection	
	var isiPad = function(){
		return (navigator.platform.indexOf("iPad") != -1);
	};

	var isiPhone = function(){
	    return (
			(navigator.platform.indexOf("iPhone") != -1) || 
			(navigator.platform.indexOf("iPod") != -1)
	    );
	};

	// OffCanvass
	var offCanvass = function() {
		$('body').on('click', '.js-fh5co-menu-btn, .js-fh5co-offcanvass-close', function(){
			$('#fh5co-offcanvass').toggleClass('fh5co-awake');
		});
	};

	// Click outside of offcanvass
	var mobileMenuOutsideClick = function() {
		$(document).click(function (e) {
	    var container = $("#fh5co-offcanvass, .js-fh5co-menu-btn");
	    if (!container.is(e.target) && container.has(e.target).length === 0) {
	    	if ( $('#fh5co-offcanvass').hasClass('fh5co-awake') ) {
	    		$('#fh5co-offcanvass').removeClass('fh5co-awake');
	    	}
	    }
		});

		$(window).scroll(function(){
			if ( $(window).scrollTop() > 500 ) {
				if ( $('#fh5co-offcanvass').hasClass('fh5co-awake') ) {
		    		$('#fh5co-offcanvass').removeClass('fh5co-awake');
		    	}
	    	}
		});
	};

	// Magnific Popup
	
	var magnifPopup = function() {
		$('.image-popup').magnificPopup({
			type: 'image',
			removalDelay: 300,
			mainClass: 'mfp-with-zoom',
			titleSrc: 'title',
			gallery:{
				enabled:true
			},
			zoom: {
				enabled: true, // By default it's false, so don't forget to enable it

				duration: 300, // duration of the effect, in milliseconds
				easing: 'ease-in-out', // CSS transition easing function

				// The "opener" function should return the element from which popup will be zoomed in
				// and to which popup will be scaled down
				// By defailt it looks for an image tag:
				opener: function(openerElement) {
				// openerElement is the element on which popup was initialized, in this case its <a> tag
				// you don't need to add "opener" option if this code matches your needs, it's defailt one.
				return openerElement.is('img') ? openerElement : openerElement.find('img');
				}
			}
		});
	};



	var animateBoxWayPoint = function() {

		if ($('.animate-box').length > 0) {
			$('.animate-box').waypoint( function( direction ) {

				if( direction === 'down' && !$(this).hasClass('animated') ) {
					$(this.element).addClass('bounceIn animated');
				}

			} , { offset: '75%' } );
		}

	};

    $(function(){
        offCanvass();
        mobileMenuOutsideClick();
        magnifPopup();
        animateBoxWayPoint();
    });

}());