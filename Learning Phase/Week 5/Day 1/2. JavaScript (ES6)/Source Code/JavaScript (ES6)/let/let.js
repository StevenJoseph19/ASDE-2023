// {{{ var v=42; }}}
// console.log(v)
{
    //Block Scope
    {
         // Nested Block scope
    }
}

if(true){
    //Block scope
}


for(let i=1;i <= 10 ;i++){
    //Block scope
}

console.log(i)

// function sum(a,b){
//     //Functions Scope
//     var result = a+b;
// }

// sum(4,3)
// result;