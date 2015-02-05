<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page isELIgnored="false"%>

<script type="text/javascript" src="http://localhost/jquery-2.1.3.js"></script>
<script type="text/javascript" src="http://localhost/removeErrorMessage.js"></script>
<script type="text/javascript" src="http://localhost/setTimeoutMessage.js"></script>
<script type="text/javascript" src="http://localhost/ajax.js"></script>

<link rel="stylesheet" href="http://localhost/my_styles.css" type="text/css">


<html>
	<head>
    	<meta charset="utf-8">
        <title>My test page!</title>
    </head>
<body>
 		<header class="header">
            <img src="http://localhost//logo/snow_logo.png" alt="" class="snow-logo">
     		<div class="text">
      			<p class="text-line-first">Твой экстрим,</p>
      			<p class="text-line-second">твои правила,</p>
      			<p class="text-line-third">твой взгляд!</p>
       		</div>

            <div class="social-logo">
            	<img src="http://localhost//logo/facebook_logo.png" alt="">
            	<img src="http://localhost//logo/twitter_logo.png">
            	<img src="http://localhost//logo/google_logo.png">
            	<img src="http://localhost//logo/red_blue_logo.png">
            </div>
            <div class="toolbar">
            	<p class="tool-first">Кто мы?</p>
                <div class="tool-second">Что мы умеем?</div>
                <div class="tool-third">Обратная связь</div>
            </div>
 		</header>

        <main>
        <div class="background">
        	<div class="video-content">
                <div class="content-first">
              	    <img style="border:6px solid white;" src="http://localhost//background/snowboard.png" alt="" width="470">
                    <img src="http://localhost//logo/arrow_left.png" class="arrow-left">
               	    <img src="http://localhost//logo/arrow_right.png" class="arrow-right">
                    <img src="http://localhost//logo/radio_button.png" class="radio-button-first" width="18">
                    <img src="http://localhost//logo/radio_button.png" class="radio-button-second" width="18">
                    <img src="http://localhost//logo/radio_button.png" class="radio-button-third" width="18">
                </div>

                <div class="content-second">
               	    <img style="border:2px solid white;" src="http://localhost//background/snow_blog_first.png" width = "200px" height="66" hspace="15">
                    <img src="http://localhost//background/video_text.png" class="arena">
                    <div class="text-video">Видео</div>
                    <img src="http://localhost//pictures/play.png" class="play">

                    <img style="border:2px solid white;" src="http://localhost//background/snow_blog_second.png" width="200" height="66" hspace="15" vspace="16">
                    <img src="http://localhost//background/video_text.png" class="photo">
                    <div class="text-photo">Фото</div>
                    <img style="border:2px solid white;" src="http://localhost//background/snow_blog_third.png" width ="200" height="66" hspace="15">
              	    <img src="http://localhost//background/video_text.png" class="snow">
                    <div class="text-press">Пресса <div class="press">о нас</div>
                </div>
            </div>

        </div>

        <div class="article-content">
            Ну и что ты сидишь?! Оторвись от дивана и вставай на сноуборд!
            <strong>Пришло твое время показать себя!</strong> А наши операторы и фотографы тебе в этом помогут :)
        </div>

        <div class="title">
            Обратная связь
        </div>

        <article>
            <div class="text">
            	Чтобы записать незабываемое видео или снять чумовую фотосессию в снежных горах на сноуборде, заполните форму и мы свяжемся с вами в ближайшее время.
            </div>
            <div class="send-successful"></div>
        </article>

        <div class="ground">
            <div class="edit-form">
  	            <form id="userForm" method="post">
				    <div class="form-text">
					    <div class="name">Имя<span>*</span></div>
			  				<p class="indent" class="surname">Фамилия<span>*</span></p>
                        	<p class="indent"><div class="email">E-mail<span>*</span></div></p>
                            <p><div class="comments">Комментарий
                        </div></p>
                    </div>

			        <div form-action>
			            <input id="first" name="first" placeholder="Input name" type="text" oninput="removeErrorName()"
			                value="${field['name']}"  class="text" autocomplete="off"/>
                        <span class="incorrect-input" id="nameFail">Имя введено некорректно!</span>

			            <p><input id="last" name="last" placeholder="Input surname" type="text" oninput="removeErrorSurname()"
			                value="${field['surname']}"  class="text" autocomplete="off"/>
			            <span class="incorrect-input" id="surnameFail">Фамилия введена некорректно!</span></p>

			            <p><input id="email" placeholder="Input e-mail" name="email" type="text" oninput="removeErrorEmail()"
			                value="${field['mail']}"  class="text" autocomplete="off"/>
                        <span class="incorrect-input" id="emailFail">E-mail введен некорректно!</span></p>
                    </div>

                    <div class="form-action-1">
                        <div>
                            <input id="photo" type="radio" name="rad" value="photo"
                                class="radio" onchange="removeErrorService()"/> Фотосъемка

                            <span class="incorrect-radio" id="radioFail">Выберите услугу!</span>

                            <p class="first_check">
                            <input id="video" type="radio" name="rad" onchange="removeErrorService()"
                                value="video" class="radio"/> Видеосъемка</p>
                        </div>

			  			<div class="second_check">
			  			    <input id="our" type="checkbox" value="on" name="our"
			  			        class="radio"/> Наличие собственной экипировки
			  			</div>

			  			<div class="textarea"><textarea rows="5" id="comments" name="comments"
			  			    placeholder="Your comments" class="box" autocomplete="off" ></textarea>
			  			</div>

					</div>

	     		    <div class="send">
					    <button type="submit" class="submit" onclick="madeAjaxCall(); return false;">Оставить заявку</button>
				    </div>
			    </form>
   			</div>
  		</div>
        </main>

        <footer>
        	<img src="http://localhost//pictures/snowboard_footer.png" class="snowboard-footer">
            <div class="text-contact">
            	644000, Город, ул. Улицаулица, 334
				<p>Телефон: <span class="contact-phone">(123) 34-56-78</span></p>
            </div>
            <div class="text-company">
            	© 2013 SnowRIP Company
            </div>
        </footer>
	</body>
</html>