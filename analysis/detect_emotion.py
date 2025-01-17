<!doctype html>
<html lang='en' class='no-js'>
<head>
<meta charset='utf-8' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Liemo - discover your emotions</title>
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="css/simple-timeline.css">
<link rel="stylesheet" type="text/css" href="css/foundation.css">

<!-- CANVAS JOERN -->
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
  <script type="text/javascript">


function sortResults(node,prop, asc) {
    node = node.sort(function(a, b) {
        if (asc) return (a[prop] > b[prop]) ? 1 : ((a[prop] < b[prop]) ? -1 : 0);
        else return (b[prop] > a[prop]) ? 1 : ((b[prop] < a[prop]) ? -1 : 0);
    });
    
}

  window.onload = function () {
    var chart = new CanvasJS.Chart("chartContainer",
    {
      zoomEnabled: true,
      animationEnabled: true,
      title:{
       text: ""
     },height:500,
     axisX: {
      title:"Valance",
      maximum: 50,
      minimum: -50,
      stripLines:[
      {                
	value:0
      }],lineThickness:0,gridThickness:0		

    },
    axisY: {
      title:"Arousal",
      maximum: 50,
      minimum: -50,
      stripLines:[
      {                
	value:0
      }],lineThickness:0,gridThickness:0			
    },

    legend:{
      verticalAlign: "bottom",
      horizontalAlign: "left"

    },
    data: [
    {        
      type: "scatter", 
      legendText: "Size of Bubble Represents Population",
      showInLegend: true,
      legendMarkerType: "circle",
      markerColor:"#4682B4",
      legendMarkerColor: "grey",
      toolTipContent: "<span style='\"'color: {color};'\"'><strong>{name}</strong></span><br/><strong>Arousal</strong> {x}<br/> <strong>Valance</strong> {y}<br/><p><img src='\"'{imgurl}'\"' width=50 height=50></img></p><div id=tag_list>{tags}</div>",
dataPoints: [      
	
       ]
     }
     ]
   });

obj=jQuery.parseJSON("[{\"imageUrl\":\"https://app-cdnandbuckets-privatebucket-1nx6pcmahiqo5.s3.amazonaws.com/private/users/b925c35377f548e890be5befb84cb572/renders/g1_hd/d49d62efcae140c1973abc221c916c9f.jpg\",\"score\":0.4768772764081197,\"arousal\":3.025621270768399,\"valence\":-3.7730110475603396,\"tags\":[\"indoors\",\"auto post production filter\",\"transfer print\",\"window\",\"home interior\",\"wall\",\"door\",\"glass - material\",\"domestic room\",\"transparent\",\"wall - building feature\",\"simplicity\",\"mirror\",\"open\",\"glass\",\"contemporary\",\"home\",\"urban\",\"control\",\"context\"]},{\"imageUrl\":\"https://app-cdnandbuckets-privatebucket-1nx6pcmahiqo5.s3.amazonaws.com/private/users/b925c35377f548e890be5befb84cb572/renders/g1_hd/da6c44402f524d199c46e2a8bb91002f.jpg\",\"score\":null,\"arousal\":1.7078523938041084,\"valence\":-1.8599924321254955,\"tags\":[]},{\"imageUrl\":\"https://app-cdnandbuckets-privatebucket-1nx6pcmahiqo5.s3.amazonaws.com/private/users/b925c35377f548e890be5befb84cb572/renders/g1_hd/db2419c6dd4048d194a32079583cac02.jpg\",\"score\":null,\"arousal\":4.735704994983754,\"valence\":-2.4298232716897705,\"tags\":[]},{\"imageUrl\":\"https://app-cdnandbuckets-privatebucket-1nx6pcmahiqo5.s3.amazonaws.com/private/users/b925c35377f548e890be5befb84cb572/renders/g1_hd/db760fb6a51c4ec7be17341d636aa412.jpg\",\"score\":null,\"arousal\":2.959759108890607,\"valence\":-0.4792881072550603,\"tags\":[]},{\"imageUrl\":\"https://app-cdnandbuckets-privatebucket-1nx6pcmahiqo5.s3.amazonaws.com/private/users/b925c35377f548e890be5befb84cb572/renders/g1_hd/df62953fb1c54e75ba18772f7f9d27be.jpg\",\"score\":null,\"arousal\":1.6469492094437408,\"valence\":4.519850142106419,\"tags\":[]},{\"imageUrl\":\"https://app-cdnandbuckets-privatebucket-1nx6pcmahiqo5.s3.amazonaws.com/private/users/b925c35377f548e890be5befb84cb572/renders/g1_hd/e42b25772dc647eba143c1851f2a0855.jpg\",\"score\":0.13211162367756746,\"arousal\":3.444676973274401,\"valence\":2.1028685443174187,\"tags\":[\"auto post production filter\",\"transfer print\",\"indoors\",\"window\",\"home interior\",\"sitting\",\"lifestyles\",\"glass - material\",\"real node\",\"front view\",\"young adult\",\"transparent\",\"waist up\",\"young men\",\"contemplation\",\"alone\",\"lifestyles\",\"person\",\"togetherness\"]},{\"imageUrl\":\"https://app-cdnandbuckets-privatebucket-1nx6pcmahiqo5.s3.amazonaws.com/private/users/b925c35377f548e890be5befb84cb572/renders/g1_hd/e4e2ccbbd9264814b9b00f9276ef63d4.jpg\",\"score\":6.84715511684697E-4,\"arousal\":0.6721636142156884,\"valence\":2.3265717387676244,\"tags\":[\"indoors\",\"window\",\"home interior\",\"auto post production filter\",\"transfer print\",\"wall\",\"glass - material\",\"transparent\",\"door\",\"glass\",\"curtain\",\"wall - building feature\",\"domestic room\",\"one person\",\"open\",\"occupation\",\"home\",\"contemporary\",\"business\",\"contemplation\"]},{\"imageUrl\":\"https://app-cdnandbuckets-privatebucket-1nx6pcmahiqo5.s3.amazonaws.com/private/users/b925c35377f548e890be5befb84cb572/renders/g1_hd/e6eed5e5e21e4b1eb2bd5caf43afdc62.jpg\",\"score\":null,\"arousal\":2.5847602446277627,\"valence\":-3.8501006128127524,\"tags\":[]},{\"imageUrl\":\"https://app-cdnandbuckets-privatebucket-1nx6pcmahiqo5.s3.amazonaws.com/private/users/b925c35377f548e890be5befb84cb572/renders/g1_hd/e928220e89064ee2bee606188980a362.jpg\",\"score\":0.04515108805863233,\"arousal\":4.281137677175774,\"valence\":-4.971198178949267,\"tags\":[\"indoors\",\"auto post production filter\",\"transfer print\",\"home interior\",\"sitting\",\"window\",\"lifestyles\",\"casual clothing\",\"real node\",\"young adult\",\"young men\",\"togetherness\",\"front view\",\"waist up\",\"occupation\",\"happiness\",\"contemplation\",\"confidence\",\"togetherness\"]},{\"imageUrl\":\"https://app-cdnandbuckets-privatebucket-1nx6pcmahiqo5.s3.amazonaws.com/private/users/b925c35377f548e890be5befb84cb572/renders/g1_hd/f5c07a5c9e6349f3a9cded6198726c5b.jpg\",\"score\":null,\"arousal\":0.07505245347636968,\"valence\":4.544704306403601,\"tags\":[]},{\"imageUrl\":\"https://app-cdnandbuckets-privatebucket-1nx6pcmahiqo5.s3.amazonaws.com/private/users/b925c35377f548e890be5befb84cb572/renders/g1_hd/f9422f981f43486e8a7918de30d6bc17.jpg\",\"score\":0.0291126349634776,\"arousal\":-0.1825140685129707,\"valence\":1.7141033685764722,\"tags\":[\"indoors\",\"window\",\"home interior\",\"auto post production filter\",\"transfer print\",\"sitting\",\"glass - material\",\"door\",\"lifestyles\",\"young adult\",\"real node\",\"transparent\",\"wall\",\"casual clothing\",\"occupation\",\"happiness\",\"business\",\"confidence\",\"home\"]}]");
sortResults(obj,"arousal",false);
	rank=0
	content=""

$.each(obj, function(i, item) {
	rank++;
	tags_json=item.tags
	tags_str="";
	$.each(tags_json,function(j,tag){
	tags_str+="#"+tag+"<br>"
	});
	chart.options.data[0].dataPoints.push({x:item.arousal*10,y:item.valence*10,z:1,name:"Photo "+i,imgurl:item.imageUrl,tags:tags_str});  
	//$("#expressive_pics").html("hi")

	if(rank<10)
		content+="<p><img src="+item.imgurl+">:"+Math.floor(item.arousal)+"<p>"
});

	$("#expressive_pics").html(content)
emotions=new Array(["pleased","excited","aroused","distressed","miserable","depressed","sleepy","relaxed"]);
chart.render();
}
</script>
<script type="text/javascript" src="assets/canvasjs.min.js"></script>

<style>
	#nav {
		position: relative;
		width: 100%;
		height: 80px;
		clear: both;
	}
	
	.Logo {
		float: left;
		width: 100%;
	}
	
	.Logo h1{
		font-family: 'Open Sans Condensed';
		font-size: 36px;
		margin-left: 20px;
		margin-top: 15px;
		float: left;
	}
	
	h2 {
		font-family: 'Open Sans Condensed';
		font-size: 21px;
		margin-left: 45%;
		margin-top: 5px;
		float: left;		
	}
	
	.Logo p {
		margin-top: 32px;
		margin-left: 80%;
		margin-right: 10px;
		font-family: 'Open Sans Condensed';
		font-size: 12px;
		float: left;
	}
	.Login img {	
		margin-top: 5px;
	}
	hr {
		border: solid #DDDDDD;
	    border-width: 1px 0 0;
    	clear: both;
	    height: 0;
	    margin: 0;
	}
</style>

<!-- CANVAS END -->
</head>

<body>
<!-- Nav -->
	<div id="nav">
		<div class="Logo">
			<h1>Liemo</h1>
			<!-- <h2>Discover your emotions</h2> -->
			<p>Daniel</p>
			<img width="25px" height="25px" style="margin-top: 28px;"src="assets/login.jpg">
		</div>
		<div class="jquery-script-clear"></div>
	</div>
<hr>	
<h2>Discover your emotions</h2>
	<div id='flash'>
		<button class='yselect' id="yprev"><</button>
	  	<p class='currentYear'>0</p>
		<button class='yselect' id="ynext">></button>
			<div class='dateRight'>
    			<p class='currentDate'>0</p>
	  		</div>
	<div id='timelineWrap'>
    	<div class='months'>
		<div class='monthLine firstlast' style="left: 0px"></div>
		<div class='monthLine' style="left: 70.833px"></div>
		<div class='monthLine' style="left: 140.666px"></div>
		<div class='monthLine' style="left: 210.999px"></div>
		<div class='monthLine' style="left: 281.332px"></div>
		<div class='monthLine' style="left: 351.665px"></div>
		<div class='monthLine' style="left: 421.998px"></div>
		<div class='monthLine' style="left: 492.331px"></div>
		<div class='monthLine' style="left: 562.664px"></div>
		<div class='monthLine' style="left: 632.997px"></div>
		<div class='monthLine' style="left: 703.33px"></div>
		<div class='monthLine' style="left: 773.663px"></div>
		<div class='monthLine firstlast' style="left: 849px"></div>
	</div>
</div>
<!-- CONTENT -->
  <div id="contentWrap row">
    <div class="large-1 columns">
      <div class='dbuttons'>
        <button class='dselect' id='dprev'><</button>
      </div>
    </div>
<!--
    <div class='tlcontainer large-10 columns row' data-date='2012-03-12'>
      <div class="large-6 columns"> <img src="http://static.pexels.com/wp-content/uploads/2015/01/idyllic-lake-landscape-4062-824x550.jpeg" alt="me" /> </div>
      <div class='large-6 columns'>
        <p class="eventTitle">Simple Timeline 0.1</p>
        <p class="eventDate">2012-03-12</p>
        <p class="eventContent"> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ac ante porttitor, rhoncus felis ac, finibus massa. Duis ligula mauris, condimentum quis cursus eu, cursus a augue. Vivamus tempus, libero ultricies maximus tristique, leo ante accumsan dui, ut tincidunt lorem risus nec arcu. Duis quis quam rhoncus, rutrum nulla in, tempor dui. Aliquam erat volutpat. Duis vel elit convallis, dignissim turpis vitae, venenatis velit. In iaculis dignissim lacus, id sodales dui pharetra vel. Vivamus ac ante odio. Maecenas orci nulla, dapibus ac sollicitudin eu, facilisis ut erat. Aliquam facilisis metus vitae mauris posuere rutrum.<br/>
          <br/>
          Donec mi nulla, venenatis ut elit et, volutpat auctor nisl. Fusce laoreet eu dui at faucibus. Proin tempor tempus mauris, suscipit cursus augue. In sed erat massa. Duis non tortor nunc. Nunc pellentesque leo vitae ipsum pretium, vel porttitor tellus fermentum. </p>
      </div>
    </div>
-->
    <div class='tlcontainer large-10 columns row' data-date='2012-03-12'>
		<div id="chartContainer" style="height: 300px; width: 100%;"></div>
		<div id="expressive_pics"></div>
    </div>
    
    
    <div class=" large-1 columns">
      <div class='dbuttons'>
        <button class ='dselect' id='dnext'>></button>
      </div>
    </div>
  </div>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> 
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script> 
<script src="simple-timeline.jquery.js"></script> 
<script>

  $('div.tlcontainer').simpleTimeline();
  
</script>

<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>

</body>
</html>