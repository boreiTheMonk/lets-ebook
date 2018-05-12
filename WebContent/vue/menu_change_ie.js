
$(document).ready(function() {
//$('.categorie_content').gradient({ topcolor: '#fa9492', bottomcolor: '#ab4143', horizontal:false, opacity:50});
//$('.toto').gradient({ rightcolor: '#ab4143', leftcolor: '#fa9492', horizontal:false, opacity: 80});

//curvyCorners({
//      tl: {radius: 5},
//      tr: {radius: 5},
//      bl: {radius: 5},
//      br: {radius: 5},
//      antiAlias: true
//    },".menu");
//
//    curvyCorners({
//      tl: {radius: 0},
//      tr: {radius: 0},
//      bl: {radius: 5},
//      br: {radius: 5},
//      antiAlias: true
//    },".menu_content");






larg= $(".menu_content").width();
haut= $(".menu_content").height();
 //$(".arriere").width(larg);
 //$(".arriere").width(larg);
 $(".arriere").height(haut);
 //alert("dqsf");
// top = $(".categorie_content").offset().top;
//  left = $(".categorie_content").offset().left;
// $(".arriere").offset({top: (top+5), left: (left-7)});
alert("arriere"+($(".arriere").width())+" meu" +($(".menu_content").width()) );
////alert("categorie_content"+top+" " +left );


//alert(offset.top);

//    curvyCorners({
//      tl: {radius: 5},
//      tr: {radius: 5},
//      bl: {radius: 5},
//      br: {radius: 5},
//      antiAlias: true
//    },".arriere");

//     offset = $(".menu_content").offset();
 //alert(offset.top);
 //alert(offset.left);
 //$(".arriere").offset({top: (offset.top+10), left: (offset.left-10)});
 //$(".arriere").offset({top: (578), left: (5)});
 // $(".ar").offset({top: (578), left: (5)});
});

