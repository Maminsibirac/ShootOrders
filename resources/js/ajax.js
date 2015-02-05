
function madeAjaxCall(){
    var name = $("#first").val();
    var surname = $('#last').val();
    var email = $('#email').val();
    var rad = $("input[type='radio'][name='rad']:checked").val();
    var check = $("input[type='checkbox'][name='our']:checked").val();
    var comments = $('#comments').val();

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/sb/protected",
        cache: false,
        data: {
            first: name, last: surname, email: email, rad: rad, our: check, comments: comments
        },
        dataType: "json",
        success: function(response) {
            if(response['success']) {          
                $('#first"').val("");
	        $('#last').val("");
	        $('#email').val("");
		$('#comments').val("");
            	$("input[type='checkbox'][name='our']:checked").val("on");
	    }
	    
	    if(!response["first"]) {
		$("#nameFail").show();
	    } 

	    if(!response["last"]) {
		$("#surnameFail").show();
	    } 

	    if(!response["email"]) {
		$("#emailFail").show();
	    }

	    if(!response["service"]) {
		$('#radioFail').show();
	    }
        },
        error: function(){
            alert('Error while request..');
        }
    });
    
}

