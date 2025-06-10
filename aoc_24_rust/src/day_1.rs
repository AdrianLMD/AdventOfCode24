use std::fs::File;
use std::io::{self, BufRead, BufReader};

fn parse_file(path: &str) -> io::Result<(Vec<i32>, Vec<i32>)> {
    let file = File::open(path)?;
    let reader = BufReader::new(file);
    let mut left_vec = Vec::new();
    let mut right_vec = Vec::new();

    for line in reader.lines() {
        let line = line?;
        let parts: Vec<&str> = line.split('#').collect();
        if parts.len() == 2 {
            let left: i32 = parts[0].parse().expect("left side not parsable");
            let right: i32 = parts[1].parse().expect("right side not parsable");
            left_vec.push(left);
            right_vec.push(right);
        }
    }

    left_vec.sort();
    right_vec.sort();

    Ok((left_vec, right_vec))
}

pub fn distance(path: &str) -> i32 {
    let (left_vec, right_vec) = match parse_file(path) {
        Ok((l, r)) => (l, r),
        Err(e) => {
            eprintln!("Error parsing: {}", e);

            return 0;
        }
    };

    let mut total_distance = 0;
    if left_vec.len() == right_vec.len() {
        for i in 0..left_vec.len() {
            total_distance += (left_vec[i]-right_vec[i]).abs()
        }
    } else {
        total_distance = 404;
    }
    total_distance
}