month = 0
balance = 10000
interest_per_month = 0.005

puts "Starting balance?"
balance = gets.chomp.to_i

puts "Monthly interest rate?"
interest_per_month = gets.chomp.to_f

def increment_month(balance, month, interest_per_month)
  month = month + 1
  balance = (1 + interest_per_month) * balance
  balance = balance - 500
  puts month.to_s + " months"
  if balance >= 0 && ((interest_per_month * balance) < 500)
    increment_month(balance, month, interest_per_month)
  elsif balance <= 0
    puts "No more money :("
  else
    puts "Making money :)"
  end
end

increment_month(balance, month, interest_per_month)