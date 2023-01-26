print("""This Find Simple Interest application will ask user to specify
the amount of a loan, an interest rate, and the number of years.
The application calculates and display the simple interest for the
given loan at the specified interest for a specified number of years.
""")
principal = int(input("Enter The Amount of Loan $"))
rate = float(input("Enter The Interest rate "))
time = int(input("Enter The Number of Years "))
intrest = principal * (rate / 100) * time
print("The interest on a loan of $", principal, "at", rate, "% intrest rate for ", time, "\nis $", round(intrest, 2));
