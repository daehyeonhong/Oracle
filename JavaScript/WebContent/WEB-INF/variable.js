// 1.Use Strict
// added in ES 5
// use this for Vanila Javascript.
'use strict';

// 2.Variable
// let (added in ES6)
let globalName = 'global name';
{
    let name = 'hong';
    console.log(name);
    name = 'hello';
    console.log(name);
}
console.log(name);
console.log(globalName);

// var (don't ever use this!)
// var hoisting (move declaration from bottom to top)
// var no block scope
{
    age = 4;
    var age;
}
console.log(age);

// 3. Constants--상수 - immutable
// let - mutable
// favor immutable data type always for a few reasons;
// - security
// - thread safety
// - reduce human mistakes
const dayInWeek = 7; const maxNumber = 5;

// 4. Variable types
// Primitive, single item; number, string, boolean, null, undefiend, symbol
// object, box container
// function, first-class function

const count = 17;// integer
const size = 17.1;// decimal number
console.log(`value: ${count}, type: ${typeof count}`);
console.log(`value: ${size}, type: ${typeof size}`);

// bigInt (fairly new, don't use it yet)
const bigInt = 123123123123123123123123123123123123n;
console.log(`value: ${bigInt}, type: ${typeof bigInt}`);

// String
const char = 'c';
const brendan = 'brandan';
const greeting = 'hello' + brendan;
console.log(`value: ${greeting}, type: ${typeof greeting}`);
const helloBob = `hi ${brendan}!`; // template literals (String)
console.log(`value: ${helloBob}, type: ${typeof hellBob}`);

// Boolean
// false: 0, null, undefined, NaN, ' '
// true: any other value
const canRead = true;
const test = 3 < 1;// false
console.log(`value: ${canRead}, type: ${typeof canRead}`);
console.log(`value: ${test}, type: ${testof test}`);

// null
let nothing = null;
console.log(`value: ${ nothing }, type: ${ typeof nothing }`);

// undefined
let x;
console.log(`value: ${ x }, type: ${ typeof x }`);

// symbol, create unique identifiers for objects
const symbol1 = Symbol('id');
const symbol2 = Symbol('id');