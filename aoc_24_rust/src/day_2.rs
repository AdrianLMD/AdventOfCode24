use std::fs::File;
use std::io::{BufRead, BufReader};

fn parse_file(path: &str) -> std::io::Result<Vec<Vec<i32>>>{
    let file = File::open(path)?;
    let reader = BufReader::new(file);
    let mut reports: Vec<Vec<i32>> = Vec::new();

    for line in reader.lines() {
        let line = line?;
        let parts: Vec<i32> = line
        .split_whitespace()
        .map(|s| s.parse::<i32>()
        .expect("not parsable"))
        .collect();
        reports.push(parts);
    }

    Ok(reports)
}

pub fn day_2_controller(path: &str) -> i32{
    let reports = parse_file(path)
    .expect("Error parsing file");
    let mut count_safe: i32 = 0;
    for i in 0..reports.len(){
        if increasing(&reports[i]) || decreasing(&reports[i]) {
            count_safe += 1;
        }
    }
    count_safe
}

fn increasing (report:&Vec<i32>) -> bool {
    for i in 0..report.len()-1 {
        if report [i] < report [i+1] || 
        (report[i]- report[i+1]).abs() > 3 || 
        (report[i]- report[i+1]).abs() < 1 {
            return false;
        }
    }
    true
}
fn decreasing (report:&Vec<i32>) -> bool {
    for i in 0..report.len()-1 {
        if report [i] > report [i+1] ||
         (report[i]- report[i+1]).abs() > 3 ||
         (report[i]- report[i+1]).abs() < 1 {
            return false;
        }
    }
    true
}