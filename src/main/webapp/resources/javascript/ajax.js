<script>
            function madeAjaxCall(){
             $.ajax({
                type: "post",
                url: "http://localhost:8080/sb/protected",
                cache: false,
                data: 'first=' + $('input[name="first"]').val(),

             });
            }
</script>