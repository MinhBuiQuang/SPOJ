#include<iostream>
#include<stack>
#include <string> 
using namespace std;


bool isCongTru(char input) {
	if(input == '+' || input == '-') return true;
	return false;
}

bool isNhanChia(char input) {
	if(input == '*' || input == '/' || input == '^') return true;
	return false;
}

string process(string input) {
	stack<char> temp;
	string result = "";
	for(int i = 0; i < input.length(); i++) {			
		char c = input.at(i);
		
		if(isCongTru(c) || isNhanChia(c)) {
			temp.push(c);
		} else if (c == '(') {
			temp.push(c);	
		} else if (c == ')') {
			while(temp.top() != '(') {				
				result += temp.top();
				temp.pop();				
			}		
			temp.pop();
			if(!temp.empty() && isNhanChia(temp.top())) {
				result += temp.top();
				temp.pop();
			}		
		} else {
			result += c;			
			if(!temp.empty() && isNhanChia(temp.top())) {
				result += temp.top();
				temp.pop();
			}
		}
	}
	return result;
}

int main() {
	int TC;
	string chuoi = "3";	
	scanf("%d", &TC);
	cin.ignore();
	while (TC--) {
		getline(cin, chuoi);
		printf("%s\n", process(chuoi).c_str());
	}

	return 0;
}
