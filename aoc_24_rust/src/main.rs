#![allow(dead_code)]
mod day_1;
mod day_2;
mod day_3;


fn main() {
    //println!("{}", day_1_run());
    //println!("{}", day_2_run());
    println!("{}", day_3_run());
}

fn day_1_run() -> String{
    let result_day_1 = day_1::day_1_controller("../inputs/Day1Table.txt");
    format!("Day1 Part1: {} \nDay1 Part2: {}"
    , result_day_1.0
    ,result_day_1.1)
}

fn day_2_run() -> String {
    let result_day_2: (i32, i32) = day_2::day_2_controller("../inputs/Day2Table.txt");
    format!("Day2 Part 1: {} \nDay2 Part2: {}"
    ,result_day_2.0
    ,result_day_2.1)
}

fn day_3_run() -> i32 {
    let result_day_3: i32 = day_3::day_3_controller("../inputs/Day3Input.txt");
    result_day_3
}