// //limitation 

// function repairMobile(brand, cb){
//     cb(null, 'done')
//     cb('failed')
// }

// repairMobile('Samsung', function(err, done){
//     if(err){
//         console.log("error repairing",err)
//     }
//     else{
//         console.log("success in repairing", done)
//     }
// })

// // limitation of callback 
// // multiple result can be given
// // 

// //promise ===> is an object which holds value of future result
// //value other than function, property and value function is method.

// //promise has three different methods
// //then, catch , finally

// //has three different state
// //pending ==> initialized
// //unFullfilled ==> success
// //onRejection ==> failure
// //settled ==> either success or failure it is termed as settled


// // NOTE :-- once promise is settled it will never change its state
// var obj = {
//     name : 'nitesh',
//     phone : 9842323,
//     email : 'nitesh@gmail.com',
//     getPhone : function(){

//     },
// }

// //syntax
// var abc = new Promise(function(success, failure){
//     //success or 1st argument is callback for success
//     //failure or 2nd argument is callback for failure
    
//     success('hi')
//     failure('helo')
// })

// abc
//     .then(function(data){
//         console.log('success result in then >>', data)
//     })
//     .catch(function(err){
//         console.log('failure in promise >>', err)
//     })
//     .finally(function(){
//         console.log('finally promise is settled')
//     })

function askMoney(amt){
    console.log('mom told me to wait')
    return new Promise(function(resolve, reject){
        setTimeout(() => {
            console.log('mom gets her salary')
            resolve();
            reject();
        }, 1000)
    })

    
}

console.log('prommise execution started')

askMoney(450)
    .then(()=>{
        console.log('here in success')
    })
    .catch(() => {
        console.log('here in failure', err)
    }) 