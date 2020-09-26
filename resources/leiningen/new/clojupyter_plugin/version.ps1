Select-String -Pattern '\(defproject {{raw-name}} "(.+)"' -Path project.clj | % { $_.Matches.Groups[1].Value }
