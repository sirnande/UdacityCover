/**
 * Created by lecad-100 on 06/06/17.
 */

    $(document).ready(function(){
        $("#vermelha a").click(function( e ){
            e.preventDefault();
            var href = $( this ).attr('href');
            $("#verde").load( href +"#verde");
        });
    });
