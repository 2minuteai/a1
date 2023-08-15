import pandas as pd
import matplotlib.pyplot as plt

# Load data from the CSV file
data = pd.read_csv("running_times.csv")

# Extract data columns
dimensions = data["Dimension"]
normal_times = data["Normal Time"]
recursive_times = data["Recursive Time"]
strassen_times = data["Strassen Time"]

# Create the plot
plt.plot(dimensions, normal_times, label="Normal Algorithm")
plt.plot(dimensions, recursive_times, label="Recursive Algorithm")
plt.plot(dimensions, strassen_times, label="Strassen's Algorithm")

# Add labels and title
plt.xlabel("Dimension")
plt.ylabel("Running Time")
plt.title("Comparison of Running Times for Matrix Multiplication Algorithms")
plt.legend()

# Show the plot
plt.show()
