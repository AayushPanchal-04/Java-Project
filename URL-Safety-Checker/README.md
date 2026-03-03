# 🛡️ URL Safety Checker

A lightweight, rule-based Java application that analyzes URLs for potential security threats and suspicious patterns. Perfect for understanding cybersecurity fundamentals and URL validation techniques.

## 📋 Overview

This command-line tool performs comprehensive security checks on URLs to identify potential phishing attempts, malware distribution sites, and other suspicious web destinations. It uses pattern matching, regex validation, and rule-based analysis to classify URLs as SAFE or SUSPICIOUS.

## ✨ Features

- **HTTPS Verification**: Ensures secure connections
- **Suspicious Keyword Detection**: Identifies common phishing/malware terms
- **Domain Analysis**: Flags suspicious TLDs and excessive subdomains
- **IP Address Detection**: Warns when IP addresses are used instead of domain names
- **Port Scanning**: Identifies unusual port numbers
- **URL Obfuscation Detection**: Catches attempts to hide malicious URLs
- **Detailed Reporting**: Provides clear explanations for each security concern

## 🔍 Security Checks Performed

| Check Type | Description |
|------------|-------------|
| Protocol | Verifies HTTPS usage |
| Keywords | Scans for phishing/malware terms (login-verify, account-verify, etc.) |
| TLDs | Flags suspicious domains (.tk, .ml, .ga, .cf, .gq, .zip, .xyz) |
| IP Addresses | Detects direct IP usage |
| Subdomains | Identifies excessive subdomain nesting |
| Special Characters | Catches '@' symbol obfuscation |
| Port Numbers | Warns about non-standard ports |

## 🛠️ Technologies Used

- **Java**: Core programming language
- **Regex**: Pattern matching for URL validation
- **Enums**: Type-safe status classification
- **Object-Oriented Design**: Clean, modular architecture


## 🚀 Usage

Run the application and enter URLs to check:

```
Enter URL to check: https://google.com
Status: ✓ SAFE
Reasons: All security checks passed

Enter URL to check: http://account-verify.tk
Status: ⚠ SUSPICIOUS
Reasons:
  • Not using HTTPS (insecure connection)
  • Contains suspicious keyword: 'account-verify'
  • Contains suspicious domain extension: '.tk'
```

Type `exit` to quit the application.

## 📝 Example Test Cases

**Safe URLs:**
- `https://google.com`
- `https://github.com`
- `https://amazon.com`

**Suspicious URLs:**
- `http://phishing-login.tk`
- `http://192.168.1.1:8888/admin`
- `https://urgent-action-verify.ml`
- `http://user@malicious-site.com`

## 🎯 Learning Objectives

This project demonstrates:
- Regular expressions for pattern matching
- Enum usage for type safety
- String manipulation and validation
- Object-oriented programming principles
- Security-first thinking in application development

## 🔒 Security Disclaimer

This tool is designed for **educational purposes** to understand URL security patterns. It uses rule-based detection and may produce false positives or miss sophisticated threats. For production security needs, use comprehensive security solutions with threat intelligence feeds and machine learning capabilities.


