mod day_1;
fn main() {
    let result_day_1 = day_1::day_1_controller("../inputs/Day1Table.txt");
    println!("Day1 Part1: {} \nDay1 Part2: {}"
    , result_day_1.0
    ,result_day_1.1);
}
