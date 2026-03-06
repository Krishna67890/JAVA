using System;
using System.Windows.Forms;

namespace Calculator
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            this.ClientSize = new System.Drawing.Size(500, 500);
        }

        private void btnCalculate_Click(object sender, EventArgs e)
        {
            try
            {
                int num1 = int.Parse(txtNum1.Text);
                int num2 = int.Parse(txtNum2.Text);
                string operation = cmbOperation.SelectedItem.ToString();
                int result = 0;

                switch (operation)
                {
                    case "Addition":
                        result = num1 + num2;
                        break;
                    case "Subtraction":
                        result = num1 - num2;
                        break;
                    case "Multiplication":
                        result = num1 * num2;
                        break;
                    case "Division":
                        result = num2 != 0 ? num1 / num2 : throw new DivideByZeroException();
                        break;
                }

                lblResult.Text = $"The result is: {result}";
            }
            catch (FormatException)
            {
                MessageBox.Show("Please enter valid numbers.");
            }
            catch (DivideByZeroException)
            {
                MessageBox.Show("Cannot divide by zero.");
            }
            catch (Exception ex)
            {
                MessageBox.Show($"An error occurred: {ex.Message}");
            }
        }
    }
}
