<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="blueLite.com.util.DBConnection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="nojs html" lang="en-US">
<head>

    <meta http-equiv="Content-type" content="text/html;charset=UTF-8"/>
    <meta name="generator" content="2018.1.0.386"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <script type="text/javascript">
        // Update the 'nojs'/'js' class on the html node
        document.documentElement.className = document.documentElement.className.replace(/\bnojs\b/g, 'js');

        // Check that all required assets are uploaded and up-to-date
        if(typeof Muse == "undefined") window.Muse = {}; window.Muse.assets = {"required":["museutils.js", "museconfig.js", "jquery.musepolyfill.bgsize.js", "jquery.musemenu.js", "jquery.watch.js", "webpro.js", "musewpdisclosure.js", "require.js", "employee-information-portal.css"], "outOfDate":[]};
    </script>

    <title>Apartment Information Portal</title>
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="css/site_global.css?crc=406358435"/>
    <link rel="stylesheet" type="text/css" href="css/master_a-master.css?crc=357733483"/>
    <link rel="stylesheet" type="text/css" href="css/employee-information-portal.css?crc=270216157" id="pagesheet"/>
    <!-- IE-only CSS -->
    <!--[if lt IE 9]>
    <link rel="stylesheet" type="text/css" href="css/iefonts_employee-information-portal.css?crc=276110031"/>
    <![endif]-->
    <!-- Other scripts -->
    <script type="text/javascript">
        var __adobewebfontsappname__ = "muse";
    </script>
    <!-- JS includes -->
    <script src="https://webfonts.creativecloud.com/lato:n3,n7:default.js" type="text/javascript"></script>
    <!--[if lt IE 9]>
    <script src="scripts/html5shiv.js?crc=4241844378" type="text/javascript"></script>
    <![endif]-->
    <!--HTML Widget code-->

    <script src="https://cdn.jsdelivr.net/particles.js/2.0.0/particles.min.js"></script>



    <style>

        #particles-js-1 {
            position: relative;
            width: 100%;
            height: 100%;
            background-color: #FFFFFF;
            background-image: url("assets/layer-0.jpg");
            background-repeat: no-repeat;
            background-size: cover;
            background-position: 50% 50%;
        }

    </style>


               <style>
input.MyButton {
width: 300px;
height:20px;
padding: 20px;
cursor: pointer;
font-weight: bold;
font-size: 80%;
background: #3366cc;
color: #fff;
border: 1px solid #3366cc;
border-radius: 10px;
}
input.MyButton:hover {
color: #ffff00;
background: #000;
border: 1px solid #fff;
}
</style>






</head>
<body class="museBGSize">

<div class="clearfix borderbox" id="page"><!-- group -->
    <div class="clearfix grpelem" id="pu133"><!-- group -->
        <div class="transition clip_frame" id="u133"><!-- image -->
            <img class="block" id="u133_img" src="images/contact%20us%20icon.png?crc=3895358489" alt="" data-heightwidthratio="0.7647058823529411" data-image-width="34" data-image-height="26"/>
        </div>
        <div class="transition clip_frame" id="u141"><!-- image -->
            <img class="block" id="u141_img" src="images/locations%20icon.png?crc=3900527344" alt="" data-heightwidthratio="0.9705882352941176" data-image-width="34" data-image-height="33"/>
        </div>
        <div class="transition clip_frame" id="u148"><!-- image -->
            <img class="block" id="u148_img" src="images/menu%20icon.png?crc=338549917" alt="" data-heightwidthratio="0.7058823529411765" data-image-width="34" data-image-height="24"/>
        </div>
        <div class="transition clip_frame" id="u155"><!-- image -->
            <img class="block" id="u155_img" src="images/photos%20icon.png?crc=3775855562" alt="" data-heightwidthratio="0.7941176470588235" data-image-width="34" data-image-height="27"/>
        </div>
        <div class="browser_width" id="u94-bw">
            <div id="u94"><!-- simple frame --></div>
        </div>
        <div class="clip_frame" id="u97"><!-- image -->
            <img class="block" id="u97_img" src="images/bluelite%c2%ae.png?crc=4730698" alt="" data-heightwidthratio="0.21544715447154472" data-image-width="246" data-image-height="53"/>
        </div>
        <div class="clip_frame" id="u105"><!-- image -->
            <img class="block" id="u105_img" src="images/bluetown%20logo.png?crc=4084020331" alt="" data-heightwidthratio="0.9692307692307692" data-image-width="65" data-image-height="63"/>
        </div>
        <div class="clearfix" id="u4013-6"><!-- content -->
            <p id="u4013-2">Kishan Samarakoon</p>
            <p id="u4013-4">Sale Manager</p>
        </div>
        <nav class="MenuBar clearfix" id="menuu4014"><!-- horizontal box -->
            <div class="MenuItemContainer clearfix grpelem" id="u4015"><!-- vertical box -->
                <div class="MenuItem MenuItemWithSubMenu borderbox museBGSize clearfix colelem" id="u4016"><!-- horizontal box -->
                    <div class="MenuItemLabel NoWrap clearfix grpelem" id="u4018-3"><!-- content -->
                        <p>&nbsp;</p>
                    </div>
                </div>
                <div class="SubMenu MenuLevel1 clearfix" id="u4020"><!-- vertical box -->
                    <ul class="SubMenuView clearfix colelem" id="u4021"><!-- vertical box -->
                        <li class="MenuItemContainer clearfix colelem" id="u4022"><!-- horizontal box --><div class="MenuItem MenuItemWithSubMenu rounded-corners clearfix grpelem" id="u4025"><!-- horizontal box --><div class="MenuItemLabel NoWrap clearfix grpelem" id="u4026-4"><!-- content --><div id="u4026-3"><p>Sign Out</p></div></div></div></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="clearfix grpelem" id="pu1447"><!-- group -->
        <div class="browser_width grpelem" id="u1447-bw">
            <div class="size_browser_width" id="u1447"><!-- custom html -->

                <div id="particles-js-1"></div>

                <script>

                    particlesJS("particles-js-1", {
                        "particles": {
                            "number": {
                                "value": 80,
                                "density": {
                                    "enable": true,
                                    "value_area": 800
                                }
                            },
                            "color": {
                                "value": "#FFFFFF"
                            },
                            "shape": {
                                "type": "circle",
                                "stroke": {
                                    "width": 0,
                                    "color": "#000000"
                                },
                                "polygon": {
                                    "nb_sides": 3
                                },
                                "image": {
                                    "src": "img/github.svg",
                                    "width": 100,
                                    "height": 100
                                }
                            },
                            "opacity": {
                                "value": 0.5,
                                "random": false,
                                "anim": {
                                    "enable": false,
                                    "speed": 1,
                                    "opacity_min": 0.1,
                                    "sync": false
                                }
                            },
                            "size": {
                                "value": 3,
                                "random": true,
                                "anim": {
                                    "enable": false,
                                    "speed": 90,
                                    "size_min": 0.1,
                                    "sync": false
                                }
                            },
                            "line_linked": {
                                "enable": true,
                                "distance": 150,
                                "color": "#FFFFFF",
                                "opacity": 0.4,
                                "width": 1
                            },
                            "move": {
                                "enable": true,
                                "speed": 6,
                                "direction": "none",
                                "random": false,
                                "straight": false,
                                "out_mode": "out",
                                "bounce": false,
                                "attract": {
                                    "enable": false,
                                    "rotateX": 600,
                                    "rotateY": 1200
                                }
                            }
                        },
                        "interactivity": {
                            "detect_on": "canvas",
                            "events": {
                                "onhover": {
                                    "enable": true,
                                    "mode": "grab"
                                },
                                "onclick": {
                                    "enable": true,
                                    "mode": "push"
                                },
                                "resize": true
                            },
                            "modes": {
                                "grab": {
                                    "distance": 140,
                                    "line_linked": {
                                        "opacity": 1
                                    }
                                },
                                "bubble": {
                                    "distance": 400,
                                    "size": 40,
                                    "duration": 2,
                                    "opacity": 8,
                                    "speed": 3
                                },
                                "repulse": {
                                    "distance": 200,
                                    "duration": 0.4
                                },
                                "push": {
                                    "particles_nb": 4
                                },
                                "remove": {
                                    "particles_nb": 2
                                }
                            }
                        },
                        "retina_detect": true
                    });

                </script>


            </div>
        </div>
        <div class="grpelem" id="u117"><!-- simple frame --></div>
        <div class="grpelem" id="u128"><!-- simple frame --></div>
        <div class="clip_frame grpelem" id="u183"><!-- image -->
            <img class="block" id="u183_img" src="images/calendar.png?crc=4071952797" alt="" data-heightwidthratio="0.8888888888888888" data-image-width="144" data-image-height="128"/>
        </div>
        <nav class="MenuBar clearfix grpelem" id="menuu669"><!-- horizontal box -->
            <div class="MenuItemContainer clearfix grpelem" id="u677"><!-- vertical box -->
                <div class="MenuItem MenuItemWithSubMenu borderbox clearfix colelem" id="u678"><!-- horizontal box -->
                    <div class="MenuItemLabel NoWrap clearfix grpelem" id="u679-4"><!-- content -->
                        <p id="u679-2">Events</p>
                    </div>
                    <div class="grpelem" id="u680"><!-- content --></div>
                </div>
                <div class="SubMenu MenuLevel1 clearfix" id="u682"><!-- vertical box -->
                    <ul class="SubMenuView transition clearfix colelem" id="u683"><!-- vertical box -->
                        <li class="MenuItemContainer clearfix colelem" id="u714"><!-- horizontal box --><div class="MenuItem MenuItemWithSubMenu clearfix grpelem" id="u716"><!-- horizontal box --><div class="MenuItemLabel NoWrap clearfix grpelem" id="u720-4"><!-- content --><div id="u720-3"><p>Event 1</p></div></div></div></li>
                        <li class="MenuItemContainer clearfix colelem" id="u786"><!-- horizontal box --><div class="MenuItem MenuItemWithSubMenu clearfix grpelem" id="u789"><!-- horizontal box --><div class="MenuItemLabel NoWrap clearfix grpelem" id="u790-4"><!-- content --><div id="u790-3"><p>Event 2</p></div></div></div></li>
                        <li class="MenuItemContainer clearfix colelem" id="u765"><!-- horizontal box --><div class="MenuItem MenuItemWithSubMenu clearfix grpelem" id="u768"><!-- horizontal box --><div class="MenuItemLabel NoWrap clearfix grpelem" id="u769-4"><!-- content --><div id="u769-3"><p>Event 3</p></div></div></div></li>
                        <li class="MenuItemContainer clearfix colelem" id="u744"><!-- horizontal box --><div class="MenuItem MenuItemWithSubMenu clearfix grpelem" id="u747"><!-- horizontal box --><div class="MenuItemLabel NoWrap clearfix grpelem" id="u748-4"><!-- content --><div id="u748-3"><p>Event 4</p></div></div></div></li>
                    </ul>
                </div>
            </div>
        </nav>
        <ul class="AccordionWidget clearfix grpelem" id="accordionu957" data-visibility="changed" style="visibility:hidden"><!-- vertical box -->
            <li class="AccordionPanel clearfix colelem" id="u958"><!-- vertical box --><div class="AccordionPanelTab borderbox clearfix colelem" id="u959-4"><!-- content --><div id="u959-3"><p>Special Meeting</p></div></div><div class="AccordionPanelContent disn clearfix colelem" id="u960"><!-- group --><div class="clearfix grpelem" id="u961-10"><!-- content --><p>Special meeting for all the executive</p><p>officers will be held at 2pm at the</p><p>Main Boardroom. Participation of all</p><p>executive officers is mandatory.</p></div></div></li>
            <li class="AccordionPanel clearfix colelem" id="u966"><!-- vertical box --><div class="AccordionPanelTab borderbox clearfix colelem" id="u967-4"><!-- content --><div id="u967-3"><p>Opening Ceremony Postponed</p></div></div><div class="AccordionPanelContent disn clearfix colelem" id="u968"><!-- group --><div class="clearfix grpelem" id="u969-12"><!-- content --><p>Opening ceremony of the</p><p>Battaramulla Apartment Complex</p><p>was postponed to 5th of</p><p>September.</p><p>-Director General</p></div></div></li>
            <li class="AccordionPanel clearfix colelem" id="u962"><!-- vertical box --><div class="AccordionPanelTab borderbox clearfix colelem" id="u963-4"><!-- content --><div id="u963-3"><p>Promotion</p></div></div><div class="AccordionPanelContent clearfix colelem" id="u964"><!-- group --><div class="clearfix grpelem" id="u965-10"><!-- content --><p>Congratulations to Mr. Kushan</p><p>Mannapperuma on his promotion as the</p><p>new Site Manger of the</p><p>Thalawathugoda site</p></div></div></li>
        </ul>
        <div class="para1 clearfix grpelem" id="u4039-4"><!-- content -->
            <p>Apartment Information Portal</p>
        </div>
        <div class="grpelem" id="u4035"><!-- custom html -->
            <style type="text/css">
                .tg  {border-collapse:collapse;border-spacing:0;border-color:transparent;}
                .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-top-width:1px;border-bottom-width:1px;border-color:#999;color:#444;background-color:#F7FDFA;}
                .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:none;border-width:0px;overflow:hidden;word-break:normal;border-top-width:0;border-bottom-width:1px;border-color:transparent;color:#fff;background-color:#26ADE4;}
                .tg .tg-fhq0{background-color:#ffffff;border-color:inherit;vertical-align:top}
                .tg .tg-i0kf{background-color:#ffffff;text-decoration:underline;color:#00009b;border-color:inherit;vertical-align:top}
                .tg .tg-ggay{font-weight:bold;background-color:#172f6d;border-color:#ffffff;vertical-align:top}
                .tg .tg-j3lq{background-color:#acc0f4;border-color:inherit;vertical-align:top}
                .tg .tg-1dmz{text-decoration:underline;background-color:#acc0f4;color:#00009b;border-color:inherit;vertical-align:top}
            </style>
            <table class="tg">
            
            
              <%

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
ResultSet rs = null;
%> 		

	<table>
					<tr>
						<td><form action="" method="get">
							<input type="text" name="q" class="formtext" placeholder="Enter a keyword...">&nbsp
							<input id="searchbutton" type="submit" value="Search">	
							</form>
						</td>
					</tr>
				</table>  
            <br><br>
            
            <table class="tg">
            
                <tr>
                	<th class="tg-ggay">ID</th>
                    <th class="tg-ggay">Apartment ID</th>
                    <th class="tg-ggay">Apartment Name</th>
                    <th class="tg-ggay">Type</th>
                    <th class="tg-ggay">Site</th>
                    <th class="tg-ggay">Room</th>
                    <th class="tg-ggay">Square Feet</th>
                    <th class="tg-ggay">Edit</th>
                    <th class="tg-ggay">Delete</th>
                    
                </tr>
               
                <tr>
                                      <%
                         
try{ 
connection = DBConnection.createConnection();
statement=connection.createStatement();
String query=request.getParameter("q");
String sql;
if(query !=null){
	
	 sql ="select * from bluelite.apartment where apartmentName like '%"+query+"%' or apartmentId like'%"+query+"%' or type like'%"+query+"%'";
}else{

sql ="select * from bluelite.apartment";

}

	

rs = statement.executeQuery(sql);




while(rs.next()){
%>
                                
             
                <tr>
                	<td class="tg-i0kf"><%=rs.getInt("id")%></td>
                    <td class="tg-i0kf"><%=rs.getInt("apartmentId")%></td>
                   <td class="tg-i0kf"><%=rs.getString("apartmentName")%></td>
                    <td class="tg-i0kf"><%=rs.getString("type")%></td>
                    <td class="tg-i0kf"><%=rs.getString("site")%></td>
                    <td class="tg-i0kf"><%=rs.getInt("room")%></td>
                    <td class="tg-i0kf"><%=rs.getDouble("squrft")%></td>
                   
                    
                    <td class="tg-i0kf"><a href="5_Sales_EditApartment.jsp?edit_id=<%=rs.getInt("id")%>">Edit</a></td>
                    <td class="tg-i0kf"><a href="5_Sales_DeleteApartment.jsp?delete_id=<%=rs.getInt("id")%>">Delete</a></td>
                    
               </tr>
               
                <%
}

statement.close(); //close statement

connection.close(); //close connection
}
catch(Exception e)
{
e.printStackTrace();
}
%>
                
                
                

            </table>

        </div>
    </div>
</div>
<!-- JS includes -->
<script type="text/javascript">
    if (document.location.protocol != 'https:') document.write('\x3Cscript src="http://musecdn.businesscatalyst.com/scripts/4.0/jquery-1.8.3.min.js" type="text/javascript">\x3C/script>');
</script>
<script type="text/javascript">
    window.jQuery || document.write('\x3Cscript src="scripts/jquery-1.8.3.min.js?crc=209076791" type="text/javascript">\x3C/script>');
</script>
<!-- Other scripts -->
<script type="text/javascript">
    // Decide whether to suppress missing file error or not based on preference setting
    var suppressMissingFileError = false
</script>
<script type="text/javascript">
    window.Muse.assets.check=function(c){if(!window.Muse.assets.checked){window.Muse.assets.checked=!0;var b={},d=function(a,b){if(window.getComputedStyle){var c=window.getComputedStyle(a,null);return c&&c.getPropertyValue(b)||c&&c[b]||""}if(document.documentElement.currentStyle)return(c=a.currentStyle)&&c[b]||a.style&&a.style[b]||"";return""},a=function(a){if(a.match(/^rgb/))return a=a.replace(/\s+/g,"").match(/([\d\,]+)/gi)[0].split(","),(parseInt(a[0])<<16)+(parseInt(a[1])<<8)+parseInt(a[2]);if(a.match(/^\#/))return parseInt(a.substr(1),
        16);return 0},f=function(f){for(var g=document.getElementsByTagName("link"),j=0;j<g.length;j++)if("text/css"==g[j].type){var l=(g[j].href||"").match(/\/?css\/([\w\-]+\.css)\?crc=(\d+)/);if(!l||!l[1]||!l[2])break;b[l[1]]=l[2]}g=document.createElement("div");g.className="version";g.style.cssText="display:none; width:1px; height:1px;";document.getElementsByTagName("body")[0].appendChild(g);for(j=0;j<Muse.assets.required.length;){var l=Muse.assets.required[j],k=l.match(/([\w\-\.]+)\.(\w+)$/),i=k&&k[1]?
        k[1]:null,k=k&&k[2]?k[2]:null;switch(k.toLowerCase()){case "css":i=i.replace(/\W/gi,"_").replace(/^([^a-z])/gi,"_$1");g.className+=" "+i;i=a(d(g,"color"));k=a(d(g,"backgroundColor"));i!=0||k!=0?(Muse.assets.required.splice(j,1),"undefined"!=typeof b[l]&&(i!=b[l]>>>24||k!=(b[l]&16777215))&&Muse.assets.outOfDate.push(l)):j++;g.className="version";break;case "js":j++;break;default:throw Error("Unsupported file type: "+k);}}c?c().jquery!="1.8.3"&&Muse.assets.outOfDate.push("jquery-1.8.3.min.js"):Muse.assets.required.push("jquery-1.8.3.min.js");
        g.parentNode.removeChild(g);if(Muse.assets.outOfDate.length||Muse.assets.required.length)g="Some files on the server may be missing or incorrect. Clear browser cache and try again. If the problem persists please contact website author.",f&&Muse.assets.outOfDate.length&&(g+="\nOut of date: "+Muse.assets.outOfDate.join(",")),f&&Muse.assets.required.length&&(g+="\nMissing: "+Muse.assets.required.join(",")),suppressMissingFileError?(g+="\nUse SuppressMissingFileError key in AppPrefs.xml to show missing file error pop up.",console.log(g)):alert(g)};location&&location.search&&location.search.match&&location.search.match(/muse_debug/gi)?
        setTimeout(function(){f(!0)},5E3):f()}};
    var muse_init=function(){require.config({baseUrl:""});require(["jquery","museutils","whatinput","jquery.musepolyfill.bgsize","jquery.musemenu","jquery.watch","webpro","musewpdisclosure"],function(c){var $ = c;$(document).ready(function(){try{
        window.Muse.assets.check($);/* body */
        Muse.Utils.transformMarkupToFixBrowserProblemsPreInit();/* body */
        Muse.Utils.prepHyperlinks(true);/* body */
        Muse.Utils.resizeHeight('.browser_width');/* resize height */
        Muse.Utils.requestAnimationFrame(function() { $('body').addClass('initialized'); });/* mark body as initialized */
        Muse.Utils.makeButtonsVisibleAfterSettingMinWidth();/* body */
        Muse.Utils.initWidget('.MenuBar', ['#bp_infinity'], function(elem) { return $(elem).museMenu(); });/* unifiedNavBar */
        Muse.Utils.initWidget('#accordionu957', ['#bp_infinity'], function(elem) { return new WebPro.Widget.Accordion(elem, {canCloseAll:false,defaultIndex:2}); });/* #accordionu957 */
        Muse.Utils.showWidgetsWhenReady();/* body */
        Muse.Utils.transformMarkupToFixBrowserProblems();/* body */
    }catch(b){if(b&&"function"==typeof b.notify?b.notify():Muse.Assert.fail("Error calling selector function: "+b),false)throw b;}})})};

</script>

<script src="scripts/require.js?crc=7928878" type="text/javascript" async data-main="scripts/museconfig.js?crc=4286661555" onload="if (requirejs) requirejs.onError = function(requireType, requireModule) { if (requireType && requireType.toString && requireType.toString().indexOf && 0 <= requireType.toString().indexOf('#scripterror')) window.Muse.assets.check(); }" onerror="window.Muse.assets.check();"></script>





</body>
</html>
