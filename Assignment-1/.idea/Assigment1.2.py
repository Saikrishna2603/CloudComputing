print("""This Find Interest application will ask user to specify the amount of 
a loan, an interest rate, and the number of years.
The application calculates and display the simple and compounded interests 
for the given loan at the specified interest rate for a specified number 
of years.\n""")
choice = "y"
while choice.lower() == "y":
    while True:
        loan = int(input("Please enter the amount of loan: $"))
        if loan > 0: #valid
            break
        else:
            print("Entry must be an integer greater than 0 Please try again.")
    while True:
        rate = float(input("Please enter the annual interest rate:"))
        if rate > 0.0: #valid
            break
        else:
            print("Entry must be a floating number greater than 0.0 Please try again.")
    while True:
        time = int(input("Please enter the number of years:"))
        if time > 0: #valid
            break
        else:
            print("Entry must be an integer greater than 0 Please try again.")
    periodic_amount_simple = periodic_amount_compounded = loan
    for n in range(1,time + 1):
        periodic_amount_simple += loan * (rate / 100)
        periodic_amount_compounded += periodic_amount_compounded * (rate / 100)
        print("period = ",n, ", periodic_amount_simple = $",periodic_amount_simple,
              ", periodic_amount_compounded = $",periodic_amount_compounded,sep="")
    total_interest_simple = periodic_amount_simple - loan
    total_interest_compounded = periodic_amount_compounded - loan
    print("The simple interest and compounded interest on a loan of $",loan,
          " at ",rate,"% yearly interest rate \nfor ",time," year",'s'if time >1 else '',
          " are $",round(total_interest_simple,2)," and $",round(total_interest_compounded,2)," respectively.",sep="")
    print("............")
    print(f"The simple interest and compounded interest on a loan of ${loan}"
          f" at {rate}% yearly interest rate \nfor {time} year{('s' if time > 1 else '')}"
          f" are ${total_interest_simple:.2f} and ${total_interest_compounded:.2f}, respectively.")
    choice = input("Do you want to do another calculation? (y for yes)")
    print()

print("Done!")