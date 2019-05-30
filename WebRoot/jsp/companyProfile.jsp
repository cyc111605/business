<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>公司简介</title>
    <link rel="stylesheet" type="text/css" href="/business/style/main.css" />
    <link rel="stylesheet" type="text/css" href="/business/style/front.css" />
</head>
<body>
<div id="top">
    <div id="top_content">
        <div id="top_left">
            <a href="/business/index.jsp">首页</a>
            <a href="/business/jsp/companyProfile.jsp">企业简介</a>
            <a href="/business/jsp/companyNews.jsp">企业新闻</a>
            <a href="/business/jsp/productShow.jsp">产品展示</a>
            <a href="/business/jsp/addAgent.jsp">加盟代理</a>
            <a href="/business/jsp/addComment.jsp">用户评论</a>
        </div>
        <div id="top_right">
    			<c:if test="${empty inname}">
    	 			<a class="right" href="/business/jsp/register.jsp">免费注册</a>
   	     			<a class="right" id="lo" href="/business/jsp/login.jsp">请登录</a>
    			</c:if>
   				<c:if test="${!empty inname}">
   					<a href="/business/Exit">退出登录</a>
    				<div id="logover">您好，${inname}</div>
    			</c:if>
    	</div>
    </div>
</div>
<div id="banner"></div>
<div id="main">
    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;杭州市无限力量科技有限公司（简称：infinite power）是一家提供物联网射频综合解决方案的高科技企业，总部位于深圳，向亚太区上千家客户提供从芯片，软件到产品的多项服务。产品覆盖无线通讯，物联网，安防监控，电力仪表，汽车电子，新能源等领域。公司设有芯片、生产、研发、软件四个事业部。旗下有四个子公司及多个集销售、服务于一体的办事处，公司核心团队大多有世界500强企业工作经验。</p>
    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;芯片事业部与国内外多家知名的IC厂家建立了授权合作关系，包括 NXP,华为海思，PANASONIC、MURATA、YANTEL、SCINTERA、JQL、ZTEMT、QUECTEL、HITACHI、MIKPOWER、MXIC、JMICRON、WPM、ACARD、LITEON、RENERGY、ENPIRION、ACTIVE-SEMI、AMP’ED、TIANMA、SAMXON、VINATECH、HANNSTAR等，为其提供技术及市场推广服务，多次获得原厂嘉奖，和原厂联合开发的芯片也得到了客户的广泛认可。</p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;杭州市无限力量科技有限公司（简称：infinite power）是一家提供物联网射频综合解决方案的高科技企业，总部位于深圳，向亚太区上千家客户提供从芯片，软件到产品的多项服务。产品覆盖无线通讯，物联网，安防监控，电力仪表，汽车电子，新能源等领域。公司设有芯片、生产、研发、软件四个事业部。旗下有四个子公司及多个集销售、服务于一体的办事处，公司核心团队大多有世界500强企业工作经验。</p>
    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;芯片事业部与国内外多家知名的IC厂家建立了授权合作关系，包括 NXP,华为海思，PANASONIC、MURATA、YANTEL、SCINTERA、JQL、ZTEMT、QUECTEL、HITACHI、MIKPOWER、MXIC、JMICRON、WPM、ACARD、LITEON、RENERGY、ENPIRION、ACTIVE-SEMI、AMP’ED、TIANMA、SAMXON、VINATECH、HANNSTAR等，为其提供技术及市场推广服务，多次获得原厂嘉奖，和原厂联合开发的芯片也得到了客户的广泛认可。</p>
    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;杭州市无限力量科技有限公司（简称：infinite power）是一家提供物联网射频综合解决方案的高科技企业，总部位于深圳，向亚太区上千家客户提供从芯片，软件到产品的多项服务。产品覆盖无线通讯，物联网，安防监控，电力仪表，汽车电子，新能源等领域。公司设有芯片、生产、研发、软件四个事业部。旗下有四个子公司及多个集销售、服务于一体的办事处，公司核心团队大多有世界500强企业工作经验。</p>
    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;芯片事业部与国内外多家知名的IC厂家建立了授权合作关系，包括 NXP,华为海思，PANASONIC、MURATA、YANTEL、SCINTERA、JQL、ZTEMT、QUECTEL、HITACHI、MIKPOWER、MXIC、JMICRON、WPM、ACARD、LITEON、RENERGY、ENPIRION、ACTIVE-SEMI、AMP’ED、TIANMA、SAMXON、VINATECH、HANNSTAR等，为其提供技术及市场推广服务，多次获得原厂嘉奖，和原厂联合开发的芯片也得到了客户的广泛认可。</p>
    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;杭州市无限力量科技有限公司（简称：infinite power）是一家提供物联网射频综合解决方案的高科技企业，总部位于深圳，向亚太区上千家客户提供从芯片，软件到产品的多项服务。产品覆盖无线通讯，物联网，安防监控，电力仪表，汽车电子，新能源等领域。公司设有芯片、生产、研发、软件四个事业部。旗下有四个子公司及多个集销售、服务于一体的办事处，公司核心团队大多有世界500强企业工作经验。</p>
    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;芯片事业部与国内外多家知名的IC厂家建立了授权合作关系，包括 NXP,华为海思，PANASONIC、MURATA、YANTEL、SCINTERA、JQL、ZTEMT、QUECTEL、HITACHI、MIKPOWER、MXIC、JMICRON、WPM、ACARD、LITEON、RENERGY、ENPIRION、ACTIVE-SEMI、AMP’ED、TIANMA、SAMXON、VINATECH、HANNSTAR等，为其提供技术及市场推广服务，多次获得原厂嘉奖，和原厂联合开发的芯片也得到了客户的广泛认可。</p>
</div>
<div id="bottom">©版权所有 第四组 企业网站</div>
</body>
</html>