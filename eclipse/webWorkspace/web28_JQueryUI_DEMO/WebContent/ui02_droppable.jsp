<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>jQuery UI Droppable - Default functionality</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/sunny/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <style>
        #clothing {
        	margin-left: 3px;
        	float: left;
        	width: 500px;
        	margin-right: 50px;
        }
        #cart {
        	float: left;
        	width: 450px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            //1. 어코디언 적용
            $('#catalog').accordion({
                heightStyle: 'content', 
                collapsible: true
            });

            //2. draggable 적용
            $('#catalog li').draggable({
                helper: 'clone', //복사본을 만들어서 draggable해라
                appendTo: '#cart'
            });
            
            //3. droppable..적용
            $('#cart ol').droppable({
                drop: function(event, ui) {
                    $(this).find('.placeholder').remove();
                    var uidrag = ui.draggable.text();

                    $(this).append('<li>' + uidrag + '</li>');
                }
            });
        } );
    </script>
</head>
<body>
    <div id="clothing">
        <h2 class="ui-widget-header">카 달 로 그</h2>
        <!-- 드래그 하는 대상들... -->
        <div id="catalog">
            <h2><a href="#">상의류</a></h2>
            <div>
                <ul>
                    <li>블라우스</li>
                    <li>티셔츠</li>
                    <li>폴라티</li>
                    <li>바바리</li>
                    <li>가디건</li>
                </ul>
            </div>

            <h2><a href="#">하의류</a></h2>
            <div>
                <ul>
                    <li>스커트</li>
                    <li>정장바지</li>
                    <li>칠부바지</li>
                    <li>숏팬츠</li>
                </ul>
            </div>

            <h2><a href="#">액세서리</a></h2>
            <div>
                <ul>
                    <li>시계</li>
                    <li>백팩</li>
                    <li>핸드백</li>
                    <li>플랫슈즈</li>
                    <li>손가방</li>
                    <li>반지갑</li>
                </ul>
            </div>
        </div>
    </div>

    <!-- drop할 영역을 지정...cart -->
    <div id="cart">
        <h2 class="ui-widget-header">Clothing Cart</h2>
        <div class="ui-widget-content">
            <ol>
                <li class="placeholder">Dropping Here!!!</li>
            </ol>
        </div>
    </div>
</body>
</html>