use std::fs::File;
use std::io::{BufRead, BufReader};
use regex::Regex;

fn parse_file(path: &str) -> std::io::Result<String>{
    let file = File::open(path)?;
    let mut reader = BufReader::new(file);
    
    let mut line: String = String::new();
    reader.read_line(&mut line)?;

    Ok(line)
}

pub fn day_3_controller(path: &str) -> i32{
    let line:String = parse_file(path).expect("error parsing file");
    logic(&line)
}

fn logic(line: &str) -> i32{

    let mut sum: i32 = 0;
    let re = Regex::new(r"mul\((\d+),(\d+)\)").unwrap();
    for caps in re.captures_iter(line) {
        let x: i32 = caps[1].parse().unwrap();
        let y: i32 = caps[2].parse().unwrap();
        
        sum += x*y;
    }
    sum
}