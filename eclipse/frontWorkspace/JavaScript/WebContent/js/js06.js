checkAge = () => {
    var age = document.ageFrm.age; //폼
    if(age.value == "") {
        alert("나이를 입력하세요");
    } else if(isNaN(age.value)){
        alert("나이는 숫자로 입력하세요");
    } else if(age.value >= 19) {
        alert(age.value + "는 성인임으로 입장 하실수 있습니다.");
    } else {
        alert("미성년은 입장 불가입니다.");
    }
    age.value = "";
    age.focus();
}