#include<iostream>
#include<stack>
#include <string> 

using namespace std;


int process(string input) {
	stack<char> temp;
	int result = 0;
	for(int i = 0; i < input.length(); i++) {
		char c = input.at(i);	
		if(c == '{') {
			temp.push(c);
		} else {
			if(temp.empty()) {	
				result++;
				temp.push('{');	
			}	
			else {				
				temp.pop();
			}				
		}
	}
	return result + temp.size()/2;
}

int main() {
	int i = 1;
	string s;
	freopen("input.txt", "r", stdin);
	while (true) {
		cin >> s;	
		if(s.at(0) == '-') break;
		printf("%d. %d\n", i++, process(s));
	}
	return 0;
}
