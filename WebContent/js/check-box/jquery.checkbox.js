$(document).ready(function()
{
    $(".checkBox,.checkBoxClear").click(function(srcc)
    {
        if ($(this).hasClass("checkBox"))
        {
            $(this).removeClass("checkBox");
            $(this).addClass("checkBoxClear");
        }
        else
        {
            $(this).removeClass("checkBoxClear");
            $(this).addClass("checkBox");
        }
    });        
});