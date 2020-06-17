<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        h1 {
            text-align: center;
        }
        #title {
            background: orange;
            width: 70%;
            margin: auto;
            text-align: right;
            padding: 5px;
            box-sizing: border-box;
        }
        #title a {
            margin-left: 40px;
        }
        #desc {
            width: 70%;
            margin: auto;
            background: papayawhip;
            box-sizing: border-box;
        }
        #left-image {
            float: left;
            width: 70%;
        }
        #left-image *{
            display: block;
        }
        #left-image img {
            width: 100%;
            height: 500px;
        }
        #left-image a {
            text-align: center;
        }
        #right-content {
            float: left;
            width: 30%;
        }
        #right-content p {
            margin: 40px;
        }
    </style>
</head>
<body>
	<h1>${item.name} 의 정보</h1>
	<p id="title">
        조회수 : ${item.count}
        <a href="#">장바구니 담기</a>
    </p>
    <div id="desc">
        <div id="left-image">
            <img src="${item.url}">
            <a href="itemList.do">상품 목록 보기</a>
        </div>
        <div id="right-content">
            <p>종 류 : ${item.name}</p>
            <p>가 격 : ${item.price}</p>
            <p style="margin-top: 100px;">설 명 : 눈 건강 살리고 피로 회복, 혈압 안정시키는 비타민 A가 많다</p>
        </div>
    </div>
</body>
</html>